package com.bankapp.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.bankapp.dao.DepositsDao;
import com.bankapp.logger.Logger;
import com.bankapp.model.Deposits;
import com.bankapp.util.ConnectionUtil;

public class DepositsDaoimpl implements DepositsDao {
	private static final String DEPOSIT_NUMBER = "deposit_number";
	private static final String TOTAL_AMOUNT = "total_amount";
	private static final String APPROVED_DATE = "approved_date";
	private static final String PAN_NUMBER = "pan_number";
	private static final String DEPOSIT_STATUS = "deposit_status";
	private static final String MATURITY_VALUE = "maturity_value";
	private static final String MATURITY_DATE = "maturity_date";
	private static final String RATE_OF_INTEREST = "rate_of_interest";
	private static final String USER_ID = "user_id";
	private static final String DATE_OF_DEPOSIT = "date_of_deposit";
	private static final String DEPOSIT_TYPE = "deposit_type";
	private static final String TENURE_IN_YEARS = "tenure_in_years";
	private static final String AMOUNT = "amount";
	private static final String ACCOUNT_NUMBER = "account_number";

	/*
	 * this method is to find rateofInterest
	 */
	@Override
	public double getInterest(double descriptionId) throws SQLException {
		String updateQuery = "select INTEREST_RATE from ADMIN_USE where DESCRIPTION_ID=?";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(updateQuery);
			statement.setDouble(1, descriptionId);
			rs = statement.executeQuery();
			if (rs.next())
				return rs.getDouble("INTEREST_RATE");
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, statement, con);
		}
		return 0;
	}

	@Override
	public long fixedDeposit(String type, double amount, double rateOfInterest, double maturityValue, int period,
			String status, String pan, String email)  {
		Connection con = null;

		String querySelect = "select USER_ID,ACCOUNT_NUMBER FROM ACCOUNT_DETAILS WHERE EMAIL=? and ACC_TYPE='SavingsAccount'";
		String query = "INSERT INTO DEPOSITS (ACCOUNT_NUMBER,USER_ID,DEPOSIT_TYPE,AMOUNT,TENURE_IN_YEARS,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS,PAN_NUMBER,Total_amount) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String selQuery = "select deposit_number from deposits where ACCOUNT_NUMBER=? and amount=?";
		LocalDate sysDate = LocalDate.now();
		Date mdate = Date.valueOf(sysDate.plusYears(period));
		long accNumber = 0;
		int userId = 0;
		long depNumber = 0;
		PreparedStatement st = null;
		PreparedStatement statement = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		ResultSet resSet = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(querySelect);
			st.setString(1, email);
			rs = st.executeQuery();
			if (rs.next()) {
				userId = rs.getInt(1);
				accNumber = rs.getLong(2);
			}
			statement = con.prepareStatement(query);
			statement.setLong(1, accNumber);
			statement.setInt(2, userId);
			statement.setString(3, type);
			statement.setDouble(4, amount);
			statement.setInt(5, period);
			statement.setDouble(6, rateOfInterest);
			statement.setDate(7, mdate);
			statement.setDouble(8, maturityValue);
			statement.setString(9, status);
			statement.setString(10, pan);
			statement.setDouble(11, amount);
			statement.executeUpdate();
			state = con.prepareStatement(selQuery);
			state.setLong(1, accNumber);
			state.setDouble(2, amount);
			resSet = state.executeQuery();
			if (resSet.next()) {
				depNumber = resSet.getLong(DEPOSIT_NUMBER);

			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (resSet != null) {
				try {
					resSet.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (state != null) {
				try {
					state.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
		}
		return depNumber;
	}

	@Override
	public long recurringDeposit(String type, double amount, double rateOfInterest, int period, double maturityValue,
			String status, String pan, String email, double totalAmount)  {
		Connection con = null;
		String query = "select USER_ID,ACCOUNT_NUMBER FROM ACCOUNT_DETAILS WHERE EMAIL=? and ACC_TYPE='SavingsAccount'";
		String queryInsert = "INSERT INTO DEPOSITS (ACCOUNT_NUMBER,USER_ID,DEPOSIT_TYPE,AMOUNT,TENURE_IN_YEARS,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS,PAN_NUMBER,Total_amount) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String selQuery = "select deposit_number from deposits where ACCOUNT_NUMBER=? and amount=?";
		LocalDate sysDate = LocalDate.now();
		Date mdate = Date.valueOf(sysDate.plusYears(period));
		long accNumber = 0;
		int userId = 0;
		long deprdNumber = 0;
		PreparedStatement st = null;
		PreparedStatement statement = null;
		PreparedStatement state = null;
		ResultSet reSet = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(query);
			st.setString(1, email);
			st.executeUpdate();
			rs = st.executeQuery();
			if (rs.next()) {
				userId = rs.getInt(1);
				accNumber = rs.getLong(2);
			}
			statement = con.prepareStatement(queryInsert);
			statement.setLong(1, accNumber);
			statement.setInt(2, userId);
			statement.setString(3, type);
			statement.setDouble(4, amount);
			statement.setInt(5, period);
			statement.setDouble(6, rateOfInterest);
			statement.setDate(7, mdate);
			statement.setDouble(8, maturityValue);
			statement.setString(9, status);
			statement.setString(10, pan);
			statement.setDouble(11, totalAmount);
			statement.executeUpdate();
			state = con.prepareStatement(selQuery);
			state.setLong(1, accNumber);
			state.setDouble(2, amount);
			reSet = state.executeQuery();
			if (reSet.next()) {
				deprdNumber = reSet.getLong(DEPOSIT_NUMBER);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (reSet != null) {
				try {
					reSet.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (state != null) {
				try {
					state.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
		}
		return deprdNumber;
	}

	@Override
	public List<Deposits> viewdeposit() throws SQLException {
		List<Deposits> loans = new ArrayList<>();
		String viewQuery = " select deposit_number,account_number,user_id,deposit_type,amount,date_of_deposit,tenure_in_years,rate_of_interest,maturity_date,maturity_value,deposit_status,pan_number,approved_date,total_amount from Deposits";
		Connection con = null;
		Statement statement = null;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			 rs = statement.executeQuery(viewQuery);
			while (rs.next()) {
				Deposits loan = new Deposits(rs.getLong(DEPOSIT_NUMBER), rs.getLong(ACCOUNT_NUMBER), rs.getInt(USER_ID),
						rs.getString(DEPOSIT_TYPE), rs.getDouble(AMOUNT), rs.getDate(DATE_OF_DEPOSIT).toLocalDate(),
						rs.getInt(TENURE_IN_YEARS), rs.getDouble(RATE_OF_INTEREST),
						rs.getDate(MATURITY_DATE).toLocalDate(), rs.getDouble(MATURITY_VALUE),
						rs.getString(DEPOSIT_STATUS), rs.getString(PAN_NUMBER), rs.getDate(APPROVED_DATE).toLocalDate(),
						rs.getDouble(TOTAL_AMOUNT));
				loans.add(loan);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(rs, statement, con);
		}

		return loans;
	}

	public boolean viewOnedeposit(long accnum) throws SQLException {
		List<Deposits> loans = new ArrayList<>();
		String viewQuery = "select deposit_number,account_number,user_id,deposit_type,amount,date_of_deposit,tenure_in_years,rate_of_interest,maturity_date,maturity_value,deposit_status,pan_number,approved_date,total_amount from Deposits  where account_number=? or deposit_number= ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs=null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(viewQuery);
			statement.setLong(1, accnum);
			statement.setLong(2, accnum);
		    rs = statement.executeQuery();
			if (rs.next()) {
				Deposits loan = new Deposits(rs.getLong(DEPOSIT_NUMBER), rs.getLong(ACCOUNT_NUMBER), rs.getInt(USER_ID),
						rs.getString(DEPOSIT_TYPE), rs.getDouble(AMOUNT), rs.getDate(DATE_OF_DEPOSIT).toLocalDate(),
						rs.getInt(TENURE_IN_YEARS), rs.getDouble(RATE_OF_INTEREST),
						rs.getDate(MATURITY_DATE).toLocalDate(), rs.getDouble(MATURITY_VALUE),
						rs.getString(DEPOSIT_STATUS), rs.getString(PAN_NUMBER), rs.getDate(APPROVED_DATE).toLocalDate(),
						rs.getDouble(TOTAL_AMOUNT));
				loans.add(loan);
				flag = true;
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			 ConnectionUtil.closeConnection(rs, statement, con);
		}
		return flag;
	}

	@Override
	public boolean updateStatus(long depnum, String status)  {
		String query = "select sysdate from dual ";
		String showQuery = "select tenure_in_years from deposits where Deposit_number='" + depnum + "'";
		String que = "UPDATE DEPOSITS SET DEPOSIT_STATUS=?,maturity_date=? , Approved_date=? WHERE deposit_number=?";
		String selectQuery = "select account_number from deposits where deposit_number=?";
		String updateQuery = "Update account_details set balance=(select balance from account_details where account_number=?)-(select amount from deposits where deposit_number=?) where account_number=?";
		Connection con = null;
		int period = 0;
		PreparedStatement pst = null;
		PreparedStatement state = null;
		PreparedStatement statement = null;
		Statement st = null;
		LocalDate date = null;
		ResultSet rs = null;
		ResultSet reSet = null;
		long accNum = 0;
		boolean flag = false;
		ResultSet resuSet = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				date = rs.getDate(1).toLocalDate();
			}
			resuSet = st.executeQuery(showQuery);
			if (resuSet.next()) {
				period = resuSet.getInt(1);

			}
			LocalDate sysDate = LocalDate.now();
			Date mdate = Date.valueOf(sysDate.plusYears(period));
			state = con.prepareStatement(que);
			state.setString(1, status);
			state.setDate(2, mdate);
			state.setDate(3, java.sql.Date.valueOf(date));
			state.setLong(4, depnum);
			int rows = state.executeUpdate();
			if (rows > 0) {
				flag = true;
			}
			pst = con.prepareStatement(selectQuery);
			pst.setLong(1, depnum);
			reSet = pst.executeQuery();
			if (reSet.next()) {
				accNum = reSet.getLong(ACCOUNT_NUMBER);
			}
			statement = con.prepareStatement(updateQuery);
			statement.setLong(1, accNum);
			statement.setLong(2, depnum);
			statement.setLong(3, accNum);
			statement.executeUpdate();
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (reSet != null) {
				try {
					reSet.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
			if (state != null) {
				try {
					state.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (resuSet != null) {
				try {
					resuSet.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}}
			if (con != null) {
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
	public List<Deposits> viewStatusUser(long accNo) throws SQLException {
		List<Deposits> list = new ArrayList<>();
		String query = "select deposit_number,account_number,user_id,deposit_type,amount,date_of_deposit,tenure_in_years,rate_of_interest,maturity_date,maturity_value,deposit_status,pan_number,approved_date,total_amount from Deposits  where account_number=? or deposit_number=?";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accNo);
			pst.setLong(2, accNo);
			rs = pst.executeQuery();

			while (rs.next()) {
				Deposits dep = new Deposits(rs.getLong(DEPOSIT_NUMBER), rs.getLong(ACCOUNT_NUMBER), rs.getInt(USER_ID),
						rs.getString(DEPOSIT_TYPE), rs.getDouble(AMOUNT), rs.getDate(DATE_OF_DEPOSIT).toLocalDate(),
						rs.getInt(TENURE_IN_YEARS), rs.getDouble(RATE_OF_INTEREST),
						rs.getDate(MATURITY_DATE).toLocalDate(), rs.getDouble(MATURITY_VALUE),
						rs.getString(DEPOSIT_STATUS), rs.getString(PAN_NUMBER), rs.getDate(APPROVED_DATE).toLocalDate(),
						rs.getDouble(TOTAL_AMOUNT));
				list.add(dep);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			 ConnectionUtil.closeConnection(rs, pst, con);
		}
		return list;

	}

	public double checkBalanceAdmin(long depnum) throws SQLException {

		String query = "select account_number from deposits where deposit_number=?";
		String selectQuery = "select BALANCE from account_details where   account_number=? ";
		PreparedStatement pst = null;
		PreparedStatement state = null;
		Connection con = null;
		ResultSet rs = null;
		ResultSet reSet = null;
		long accountNum = 0;
		double balance = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, depnum);
			reSet = pst.executeQuery();
			if (reSet.next()) {
				accountNum = reSet.getLong(ACCOUNT_NUMBER);
			}

			state = con.prepareStatement(selectQuery);
			state.setLong(1, accountNum);

			rs = state.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (state != null) {
				state.close();
			}
			if (reSet != null)
				reSet.close();
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return balance;
	}

	public double checkAmountAdmin(long depositNumber) {

		String query = "select amount from deposits where deposit_number=?";
		PreparedStatement pst = null;
		Connection con = null;
		double amount = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, depositNumber);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				amount = rs.getDouble(AMOUNT);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
		return amount;
	}

}
