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
import com.bankapp.model.Deposits;
import com.bankapp.util.ConnectionUtil;

public class DepositsDaoimpl implements DepositsDao {
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
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return 0;
	}

	@Override
	public long fixedDeposit(String type, double amount, double rateOfInterest, double maturityValue, int period,
			String status, String pan, String email) throws SQLException {
		Connection con = null;

		String querySelect = "select USER_ID,ACCOUNT_NUMBER FROM ACCOUNT_DETAILS WHERE EMAIL=? and ACC_TYPE='SavingsAccount'";
		String query = "INSERT INTO DEPOSITS (ACCOUNT_NUMBER,USER_ID,DEPOSIT_TYPE,AMOUNT,TENURE_IN_YEARS,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS,PAN_NUMBER,Total_amount) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String selQuery = "select deposit_number from deposits where ACCOUNT_NUMBER=? and amount=?";
		LocalDate sysDate = LocalDate.now();
		Date mdate = Date.valueOf(sysDate.plusYears(period));
		long accNumber = 0;
		int userId = 0;
		long depNumber = 0;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ResultSet resSet = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(querySelect);
			rs = statement.executeQuery();
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
			statement = con.prepareStatement(selQuery);
			statement.setLong(1, accNumber);
			statement.setDouble(2, amount);
			resSet = statement.executeQuery();
			if (resSet.next()) {
				depNumber = resSet.getLong("deposit_number");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (resSet != null)
				resSet.close();
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();

			}
		}
		return depNumber;
	}

	@Override
	public long recurringDeposit(String type, double amount, double rateOfInterest, int period, double maturityValue,
			String status, String pan, String email, double totalAmount) throws SQLException {
		Connection con = null;
		String query = "select USER_ID,ACCOUNT_NUMBER FROM ACCOUNT_DETAILS WHERE EMAIL=? and ACC_TYPE='SavingsAccount'";
		String queryInsert = "INSERT INTO DEPOSITS (ACCOUNT_NUMBER,USER_ID,DEPOSIT_TYPE,AMOUNT,TENURE_IN_YEARS,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS,PAN_NUMBER,Total_amount) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String selQuery = "select deposit_number from deposits where ACCOUNT_NUMBER=? and amount=?";

		LocalDate sysDate = LocalDate.now();
		Date mdate = Date.valueOf(sysDate.plusYears(period));
		long accNumber = 0;
		int userId = 0;
		long deprdNumber = 0;
		PreparedStatement statement = null;
		ResultSet rs1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, email);

			statement.executeUpdate();
			ResultSet rs = statement.executeQuery();
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
			statement = con.prepareStatement(selQuery);
			statement.setLong(1, accNumber);
			statement.setDouble(2, amount);
			rs1 = statement.executeQuery();
			if (rs1.next()) {
				deprdNumber = rs1.getLong("deposit_number");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}

			if (con != null) {
				con.close();

			}
		}
		return deprdNumber;
	}

	@Override
	public List<Deposits> viewdeposit() throws SQLException {
		List<Deposits> loans = new ArrayList<>();
		String view1 = " select deposit_number,account_number,user_id,deposit_type,amount,date_of_deposit,tenure_in_years,rate_of_interest,maturity_date,maturity_value,deposit_status,pan_number,approved_date,total_amountfrom Deposits";
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(view1);
			while (rs.next()) {
				Deposits loan = new Deposits(rs.getLong("deposit_number"), rs.getLong("account_number"),
						rs.getInt("user_id"), rs.getString("deposit_type"), rs.getDouble("amount"),
						rs.getDate("date_of_deposit").toLocalDate(), rs.getInt("tenure_in_years"),
						rs.getDouble("rate_of_interest"), rs.getDate("maturity_date").toLocalDate(),
						rs.getDouble("maturity_value"), rs.getString("deposit_status"), rs.getString("pan_number"),
						rs.getDate("approved_date").toLocalDate(), rs.getDouble("total_amount"));
				loans.add(loan);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (statement != null) {
				statement.close();
			}

			if (con != null) {
				con.close();

			}

		}

		return loans;
	}

	public boolean viewOnedeposit(long accnum) throws SQLException {
		List<Deposits> loans = new ArrayList<>();
		String view1 = "select deposit_number,account_number,user_id,deposit_type,amount,date_of_deposit,tenure_in_years,rate_of_interest,maturity_date,maturity_value,deposit_status,pan_number,approved_date,total_amount from Deposits  where account_number=? or deposit_number= ?";
		Connection con = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(view1);
			statement.setLong(1, accnum);
			statement.setLong(2, accnum);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Deposits loan = new Deposits(rs.getLong("deposit_number"), rs.getLong("account_number"),
						rs.getInt("user_id"), rs.getString("deposit_type"), rs.getDouble("amount"),
						rs.getDate("date_of_deposit").toLocalDate(), rs.getInt("tenure_in_years"),
						rs.getDouble("rate_of_interest"), rs.getDate("maturity_date").toLocalDate(),
						rs.getDouble("maturity_value"), rs.getString("deposit_status"), rs.getString("pan_number"),
						rs.getDate("approved_date").toLocalDate(), rs.getDouble("total_amount"));
				loans.add(loan);
				flag = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}

			if (con != null) {
				con.close();
			}
		}
		return flag;
	}

	@Override
	public boolean updateStatus(long depnum, String status) throws SQLException {
		String query = "select sysdate from dual ";
		String showQuery = "select tenure_in_years from deposits where Deposit_number='" + depnum + "'";
		String que = "UPDATE DEPOSITS SET DEPOSIT_STATUS=?,maturity_date=? , Approved_date=? WHERE deposit_number=?";
		String selectQuery = "select account_number from deposits where deposit_number=?";
		String updateQuery = "Update account_details set balance=(select balance from account_details where account_number=?)-(select amount from deposits where deposit_number=?) where account_number=?";
		Connection con = null;
		int period = 0;
		PreparedStatement pst = null;
		Statement st = null;
		LocalDate date = null;
		ResultSet rs = null;
		long accNum = 0;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				date = rs.getDate(1).toLocalDate();
			}
			ResultSet rs1 = st.executeQuery(showQuery);
			if (rs1.next()) {
				period = rs1.getInt(1);

			}

			LocalDate sysDate = LocalDate.now();
			Date mdate = Date.valueOf(sysDate.plusYears(period));

			pst = con.prepareStatement(que);
			pst.setString(1, status);
			pst.setDate(2, mdate);
			pst.setDate(3, java.sql.Date.valueOf(date));
			pst.setLong(4, depnum);
			int rows = pst.executeUpdate();
			if (rows > 0) {
				flag = true;
			}
			pst = con.prepareStatement(selectQuery);
			pst.setLong(1, depnum);
			ResultSet reSet = pst.executeQuery();
			if (reSet.next()) {
				accNum = reSet.getLong("account_number");
			}
			pst = con.prepareStatement(updateQuery);
			pst.setLong(1, accNum);
			pst.setLong(2, depnum);
			pst.setLong(3, accNum);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (rs != null)
				rs.close();
			if (con != null) {
				con.close();
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
			// pst.n
			rs = pst.executeQuery(query);

			while (rs.next()) {
				Deposits dep = new Deposits(rs.getLong("deposit_number"), rs.getLong("account_number"),
						rs.getInt("user_id"), rs.getString("deposit_type"), rs.getDouble("amount"),
						rs.getDate("date_of_deposit").toLocalDate(), rs.getInt("tenure_in_years"),
						rs.getDouble("rate_of_interest"), rs.getDate("maturity_date").toLocalDate(),
						rs.getDouble("maturity_value"), rs.getString("deposit_status"), rs.getString("pan_number"),
						rs.getDate("approved_date").toLocalDate(), rs.getDouble("total_amount"));
				list.add(dep);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (rs != null)
				rs.close();
			if (con != null) {
				con.close();
			}
		}
		return list;

	}

	public double checkBalanceAdmin(long depnum) throws SQLException {

		String query = "select account_number from deposits where deposit_number=?";
		String selectQuery = "select BALANCE from account_details where   account_number=? ";
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		long accountNum = 0;
		double balance = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, depnum);
			ResultSet rs1 = pst.executeQuery();
			if (rs1.next()) {
				accountNum = rs1.getLong("account_number");
			}

			pst = con.prepareStatement(selectQuery);
			pst.setLong(1, accountNum);

			rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (rs != null)
				rs.close();
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
				amount = rs.getDouble("amount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amount;
	}

}
