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
import com.bankapp.model.Transaction;
import com.bankapp.util.ConnectionUtil;

public class TransactionDaoimpl implements TransactionDao {

	@SuppressWarnings("resource")
	@Override
	public boolean depositAmount(long senderAccNum, String uname, double amount, int pinNo, long receiverAccNO)
			throws SQLException {

		String query = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = ? +(select balance from account_details where account_number=?) WHERE  ACCOUNT_NUMBER= ?  ";
		String selectQuery = "select balance from account_details where account_number=?";
		String inserQuery = "insert into transaction (sender_account_number,name,transaction_type,receiver_account_number,amount,balance,transaction_status)values(?,?,'DEPOSIT AMOUNT',?,?,?,'CREDITED')";
		String sendQuery = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = (select balance from account_details where account_number=?)-? WHERE  ACCOUNT_NUMBER= ? AND PIN_NUMBER= ? ";
		double balance = 0;
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			ps = con.prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setLong(2, receiverAccNO);
			ps.setLong(3, receiverAccNO);
			ps.executeUpdate();
			ps = con.prepareStatement(selectQuery);
			ps.setDouble(1, senderAccNum);
			ps.executeUpdate();
			rs = ps.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}
			ps = con.prepareStatement(inserQuery);
			ps.setLong(1, senderAccNum);
			ps.setString(2, uname);
			ps.setLong(3, receiverAccNO);
			ps.setDouble(4, amount);
			ps.setDouble(5, balance);
			ps.executeUpdate();
			ps = con.prepareStatement(sendQuery);
			ps.setLong(1, senderAccNum);
			ps.setDouble(2, amount);
			ps.setLong(3, senderAccNum);
			ps.setInt(4, pinNo);

			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
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
				balance = rs.getDouble("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}
		return balance;
	}

	public double viewBalanceFd(String pan) throws SQLException {

		String query1 = "select BALANCE from account_details where  Pan_number=? ";
		PreparedStatement pst = null;
		Connection con = null;
		double balance = 0;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query1);
			pst.setString(1, pan);
			rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
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
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}
		return 0;
	}

	@Override
	public List<Transaction> getbyDate(LocalDate date) throws SQLException {
		Connection con = null;
		List<Transaction> list = new ArrayList<>();
		String query = "select Sender_account_number,name,Transaction_type,Receiver_account_number,amount,transaction_status,transaction_date from transaction  where to_char(transaction_date,'yyyy-MM-dd')=? ";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(query);
			st.setDate(1, java.sql.Date.valueOf(date));
			rs = st.executeQuery();
			while (rs.next()) {
				Transaction trans = new Transaction(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getDouble(5), 0, rs.getString(6), rs.getDate(7).toLocalDate());
				list.add(trans);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return list;
	}

	@Override
	public List<Transaction> getByAccountNumberAdmin(long accNo) {
		Connection con = ConnectionUtil.getDbConnection();
		List<Transaction> list = new ArrayList<Transaction>();
		ResultSet rs = null;
		String query = " select * from transaction  where  Sender_Account_number='" + accNo
				+ "' order by transaction_date desc  ";
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				Transaction transac = new Transaction(rs.getLong(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getDouble(6), 0, rs.getString(7), rs.getDate(9).toLocalDate());
				list.add(transac);
			}
			// System.out.println(list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}
		return list;
	}

	@Override
	public List<Transaction> getByAccountNumberUser(long accNo, int pin) {
		Connection con = ConnectionUtil.getDbConnection();
		List<Transaction> list = new ArrayList<Transaction>();

		ResultSet rs = null;
		String query = "select * from transaction where  Sender_Account_number='" + accNo
				+ "' order by transaction_date desc ";
		try {
			Statement pst = con.createStatement();
			rs = pst.executeQuery(query);

			while (rs.next()) {
				Transaction trans = new Transaction(rs.getLong(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getDouble(6), 0, rs.getString(7), rs.getDate(9).toLocalDate());
				list.add(trans);
			}
			// System.out.println(list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}

		return list;
	}

	public LocalDate getDate() {
		String query = "select trunc(Sysdate) from dual";
		Connection con = ConnectionUtil.getDbConnection();
		LocalDate date = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				date = rs.getDate(1).toLocalDate();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}
		return date;
	}

}
