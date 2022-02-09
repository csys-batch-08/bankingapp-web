package com.bankapp.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.dao.TransactionDao;
import com.bankapp.logger.Logger;
import com.bankapp.model.Transaction;
import com.bankapp.util.ConnectionUtil;

public class TransactionDaoimpl implements TransactionDao {
	private static final String BALANCE2 = "balance";
	private static final String TRANSACTION_DATE = "transaction_date";
	private static final String AMOUNT = "amount";
	private static final String TRANSACTION_STATUS = "transaction_status";
	@Override
	public boolean depositAmount(long senderAccNum, String uname, double amount, int pinNo, long receiverAccNO) {
		String showQuery = "select balance from account_details where account_number=?";
		String query = "insert into transaction (sender_account_number,name,transaction_type,receiver_account_number,amount,balance,transaction_status) values(?,?,'DEPOSIT AMOUNT',?,?,?,'CREDITED')";
		double balance = 0;
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			ps = con.prepareStatement(showQuery);
			ps.setDouble(1, senderAccNum);
			ps.executeUpdate();
			rs = ps.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble(BALANCE2);
			}
			pst = con.prepareStatement(query);
			pst.setLong(1, senderAccNum);
			pst.setString(2, uname);
			pst.setLong(3, receiverAccNO);
			pst.setDouble(4, amount);
			pst.setDouble(5, balance);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			 	if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						Logger.printStackTrace(e);
						Logger.runTimeException(e.getMessage());
					}
			 	}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						Logger.printStackTrace(e);
						Logger.runTimeException(e.getMessage());
					}
				}
				if (con != null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						Logger.printStackTrace(e);
						Logger.runTimeException(e.getMessage());
					}
				}
		}
		return flag;
	}


	@Override
	public double viewBalance(long accountNumber, int pinNo) throws SQLException {
		Connection con = null;
		String query = "select BALANCE from account_details where Account_number=? and Pin_number=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		double balance = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accountNumber);
			pst.setInt(2, pinNo);
			rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble(BALANCE2);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);
		}
		return balance;
	}

	public double viewBalanceFd(String pan) throws SQLException {

		String query = "select BALANCE from account_details where  Pan_number=? ";
		PreparedStatement pst = null;
		Connection con = null;
		double balance = 0;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, pan);
			rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble(BALANCE2);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);
		}
		return balance;
	}

	@Override
	public int getPinnumber(long accountno) throws SQLException {
		String query = "select pin_number from Account_Details where account_number = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accountno);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);
		}
		return 0;
	}

	@Override
	public List<Transaction> getbyDate(LocalDate date) throws SQLException {
		Connection con = null;
		List<Transaction> list = new ArrayList<>();
		String query = "select Sender_account_number,name,Transaction_type,Receiver_account_number,amount,transaction_status,transaction_date from transaction  "
				+ "where to_char(transaction_date,'dd-MM-yyyy')=? ";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(query);
			st.setDate(1, java.sql.Date.valueOf(date));
			rs = st.executeQuery();
			while (rs.next()) {
				Transaction trans = new Transaction(rs.getLong("Sender_account_number"), rs.getString("name"),
						rs.getString("Transaction_type"), rs.getLong("Receiver_account_number"), rs.getDouble(AMOUNT),
						0, rs.getString(TRANSACTION_STATUS), rs.getDate(TRANSACTION_DATE).toLocalDate());
				list.add(trans);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.closeConnection(rs, st, con);
		}
		return list;
	}

	@Override
	public List<Transaction> getByAccountNumberAdmin(long accNo) throws SQLException {
		Connection con = null;
		List<Transaction> list = new ArrayList<>();

		ResultSet rs = null;
		PreparedStatement pst = null;
		String query = " select sender_account_number,name,transaction_type,receiver_account_number,amount,balance,transaction_status,transaction_date from transaction  where  Sender_Account_number=? order by transaction_date desc  ";
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accNo);
			rs = pst.executeQuery();

			while (rs.next()) {

				Transaction transac = new Transaction(rs.getLong("sender_account_number"), rs.getString("name"),
						rs.getString("transaction_type"), rs.getLong("receiver_account_number"), rs.getDouble(AMOUNT),
						rs.getDouble(BALANCE2), rs.getString(TRANSACTION_STATUS),
						rs.getDate(TRANSACTION_DATE).toLocalDate());
				list.add(transac);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);
		}
		return list;
	}

	@Override
	public List<Transaction> getByAccountNumberUser(long accNo) throws SQLException {
		Connection con = null;
		List<Transaction> list = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select  Sender_account_number,name,Transaction_type,Receiver_account_number,amount,transaction_status,transaction_date from transaction where  Sender_Account_number=?   order by transaction_date desc ";
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accNo);
			rs = pst.executeQuery();
			while (rs.next()) {
				Transaction trans = new Transaction(rs.getLong("Sender_account_number"), rs.getString("name"),
						rs.getString("Transaction_type"), rs.getLong("Receiver_account_number"), rs.getDouble(AMOUNT),
						0, rs.getString(TRANSACTION_STATUS), rs.getDate(TRANSACTION_DATE).toLocalDate());
				list.add(trans);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);
		}

		return list;
	}

	public LocalDate getDate() throws SQLException {
		String query = "select trunc(Sysdate) from dual";
		Connection con = null;
		LocalDate date = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				date = rs.getDate(1).toLocalDate();
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(rs, st, con);
		}
		return date;
	}

	public boolean updateBalance(long senderAccNum, double amount, int pinNo, long receiverAccNO) {
		String query = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = ? +(select balance from account_details where account_number=?) WHERE  ACCOUNT_NUMBER= ?  ";
		String sendQuery = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = (select balance from account_details where account_number=?)-? "
				+ "WHERE  ACCOUNT_NUMBER= ? AND PIN_NUMBER= ? ";

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pst = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			ps = con.prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setLong(2, receiverAccNO);
			ps.setLong(3, receiverAccNO);
			ps.executeUpdate();
			pst = con.prepareStatement(sendQuery);
			pst.setLong(1, senderAccNum);
			pst.setDouble(2, amount);
			pst.setLong(3, senderAccNum);
			pst.setInt(4, pinNo);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
		}
		return flag;

	}

}
