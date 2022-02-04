package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.dao.AccountDetailsDao;

import com.bankapp.model.AccountDetails;

import com.bankapp.util.ConnectionUtil;

public class AccountDetailsdaoimpl implements AccountDetailsDao {

	@Override
	public boolean insertAccount(AccountDetails account) throws SQLException {
		String que = "select  user_id.nextval from dual";
		String query = "INSERT INTO Account_details (USER_ID,ACC_TYPE,ACC_HOLDER_NAME,ADDRESS,CITY,PINCODE,DOB,MOBILE_NUMBER,EMAIL,IFSC_CODE,BRANCH_NAME,BALANCE,PIN_NUMBER,ACCOUNT_STATUS,Pan_number)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		int userId = 0;
		boolean flag = false;
		PreparedStatement statement = null;
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(que);
			if (rs.next())
				userId = rs.getInt(1);

			statement = con.prepareStatement(query);
			statement.setInt(1, userId);
			statement.setString(2, account.getAccountType());
			statement.setString(3, account.getAccountHolderName());
			statement.setString(4, account.getAddress());
			statement.setString(5, account.getCity());
			statement.setInt(6, account.getPincode());
			statement.setDate(7, java.sql.Date.valueOf(account.getDob()));
			statement.setLong(8, account.getMobileNumber());
			statement.setString(9, account.getEmail());
			statement.setString(10, account.getIfscCode());
			statement.setString(11, account.getBranchName());
			statement.setDouble(12, account.getBalance());
			statement.setInt(13, account.getPinNumber());
			statement.setString(14, account.getStatus());
			statement.setString(15, account.getPan());
			statement.executeUpdate();
			flag = true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (st != null) {
				st.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (true) {
				con.close();

			}
		}
		return flag;
	}

	@Override
	public List<AccountDetails> searchDetail(long accNumber, int pinNumber) throws SQLException {
		List<AccountDetails> list = new ArrayList<>();
		String validateQuery = "select  user_id,account_number,acc_type,acc_holder_name,address,city,pincode,dob,mobile_number,email,ifsc_code,branch_name,balance,pin_number,account_status,pan_number from ACCOUNT_DETAILS WHERE  ACCOUNT_NUMBER=? and PIN_NUMBER=?";

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement state = null;
		AccountDetails accDetail = null;
		try {
			state = con.prepareStatement(validateQuery);
			state.setLong(1, accNumber);
			state.setInt(1, pinNumber);
			ResultSet rs = state.executeQuery();

			if (rs.next()) {
				accDetail = new AccountDetails(rs.getInt("user_id"), rs.getLong("account_number"),
						rs.getString("acc_type"), rs.getString("acc_holder_name"), rs.getString("address"),
						rs.getString("city"), rs.getInt("pincode"), rs.getDate("dob").toLocalDate(),
						rs.getLong("mobile_number"), rs.getString("email"), rs.getString("ifsc_code"),
						rs.getString("branch_name"), rs.getInt("balance"), rs.getInt("pin_number"),
						rs.getString("account_status"), rs.getString("pan_number"));
				list.add(accDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			if (state != null) {
				state.close();
			}
			if (true) {
				con.close();

			}
		}
		return list;
	}

	@Override
	public List<AccountDetails> viewAccout() throws SQLException {
		List<AccountDetails> list = new ArrayList<>();

		String query = "select  user_id,account_number,acc_type,acc_holder_name,address,city,pincode,dob,mobile_number,email,ifsc_code,branch_name,balance,pin_number,account_status,pan_number from ACCOUNT_DETAILS order by account_number";
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				AccountDetails accDetail = new AccountDetails(rs.getInt(1), rs.getLong(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8).toLocalDate(),
						rs.getLong(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13),
						rs.getInt(14), rs.getString(15), rs.getString(16));
				list.add(accDetail);

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

		return list;
	}

	public List<AccountDetails> viewOneAccount(long num) throws SQLException {
		List<AccountDetails> list = new ArrayList<>();

		String view = "select acc_type,acc_holder_name,mobile_number,email,ifsc_code,branch_name,account_status,pan_number from  account_details where account_number='"
				+ num + "'";
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(view);

			if (rs.next()) {
				AccountDetails accDetail = new AccountDetails(rs.getInt(1), rs.getLong(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8).toLocalDate(),
						rs.getLong(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13),
						rs.getInt(14), rs.getString(15), rs.getString(16));
				list.add(accDetail);
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

		return list;
	}

	@Override
	public boolean updateUserDetailAdmin(String email1, long mobilenumber, String email) throws SQLException {
		String updateQuery = "update user_details set email=? where email=?";
		String updateQuery1 = "update account_details set email=?,mobile_number=? where email=?";
		Connection con = null;
		boolean flag = false;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(updateQuery1);
			statement.setString(1, email1);
			statement.setLong(2, mobilenumber);
			statement.setString(3, email);
			statement.executeUpdate();
			statement = con.prepareStatement(updateQuery);
			statement.setString(1, email1);
			statement.setString(2, email);
			statement.executeUpdate();
			flag = true;
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
	public boolean deleteDetails(long accountnum, String status) throws SQLException {
		String deleteQuery = "update account_details set account_status= ? where Account_number=?";
		Connection con = null;
		boolean flag = false;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(deleteQuery);
			statement.setString(1, status);
			statement.setLong(2, accountnum);
			statement.executeUpdate();
			flag = true;

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
	public String getUserId(String email) throws SQLException {
		String query = "select user_id from Account_Details where email = ?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString("user_id");
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();

			}
		}
		return null;
	}

	public int getPinnumber(long accountno) throws SQLException {
		String query = "select pin_number from Account_Details where account_number = ?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setLong(1, accountno);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();

			}
		}
		return 0;
	}

	public double checkBalance(long accnum) throws SQLException {
		String que = "Select Balance from account_details where Account_number='" + accnum + "'";
		Connection con = null;
		double balance = 0;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(que);
			if (rs.next()) {
				balance = rs.getDouble(1);
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

		return balance;
	}

	public boolean checkaccount(long num) throws SQLException {
		String que = "select Account_number from account_details where account_number= '" + num + "'";
		boolean flag = false;
		long accNum = 0;
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(que);
			if (rs.next()) {
				accNum = rs.getLong(1);
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
}
