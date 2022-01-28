package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.dao.AccountDetailsDao;
import com.bankapp.dao.UserDetailsDao;
import com.bankapp.model.AccountDetails;
import com.bankapp.model.UserDetails;
import com.bankapp.util.ConnectionUtil;

public class AccountDetailsdaoimpl implements AccountDetailsDao {

	public boolean insertAccount(AccountDetails account) throws SQLException  {
		String que = "select  user_id.nextval from dual";
		String query = "INSERT INTO Account_details (USER_ID,ACC_TYPE,ACC_HOLDER_NAME,ADDRESS,CITY,PINCODE,DOB,MOBILE_NUMBER,EMAIL,IFSC_CODE,BRANCH_NAME,BALANCE,PIN_NUMBER,ACCOUNT_STATUS)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		int accNumber = 0;
		boolean flag = false;
		PreparedStatement statement=null;

		try {
			  statement = con.prepareStatement(que);
			ResultSet rs = statement.executeQuery();
			if (rs.next())
				accNumber = rs.getInt(1);

			statement = con.prepareStatement(query);
			statement.setInt(1, accNumber);
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
			statement.executeUpdate();
			flag = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			if(statement!=null)
			{
				statement.close();
			}
			if(con!=null)
			{
				con.close();
				 
			}
		}
		return flag;
	}

	public List<AccountDetails> searchDetail(long accNumber, int pinNumber) throws SQLException {
		List<AccountDetails> list = new ArrayList<AccountDetails>();
		ConnectionUtil conUtil = new ConnectionUtil();

		String validateQuery = "select * from ACCOUNT_DETAILS WHERE  ACCOUNT_NUMBER='" + accNumber
				+ "' and PIN_NUMBER='" + pinNumber + "'";

		Connection con = conUtil.getDbConnection();
		Statement statement=null;
		AccountDetails accDetail = null;
		try {
			  statement = con.createStatement();
			ResultSet rs = statement.executeQuery(validateQuery);

			if (rs.next()) {
				accDetail = new AccountDetails(rs.getInt(1), rs.getLong(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8).toLocalDate(), rs.getLong(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
				list.add(accDetail);
			}

		} catch (SQLException e) {
			 
			e.printStackTrace();

		}finally {
			if(statement!=null)
			{
				statement.close();
			}
			if(con!=null)
			{
				con.close();
				 
			}
		}
		return list;
	}

	public List<AccountDetails> viewAccout() throws SQLException {
		List<AccountDetails> list = new ArrayList<AccountDetails>();

		String view = "select * from  account_details";
		Connection con = ConnectionUtil.getDbConnection();
		Statement statement=null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(view);
			while (rs.next()) {
				AccountDetails accDetail = new AccountDetails(rs.getInt(1), rs.getLong(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8).toLocalDate(),
						rs.getLong(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13),
						rs.getInt(14), rs.getString(15), rs.getString(16));
				list.add(accDetail);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			if(statement!=null)
			{
				statement.close();
			}
			if(con!=null)
			{
				con.close();
				 
			}
		}

		return list;
	}

	public List<AccountDetails> viewOneAccount(long num) {
		List<AccountDetails> List = new ArrayList<AccountDetails>();

		String view = "select acc_type,acc_holder_name,mobile_number,email,ifsc_code,branch_name,account_status,pan_number from  account_details where account_number='" + num + "'";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(view);
			
			if (rs.next()) {
				AccountDetails accDetail = new AccountDetails(0, num, rs.getString(1),
						rs.getString(2), null,null,0,null,
						rs.getLong(3), rs.getString(4), rs.getString(5), rs.getString(6), 0,
						 0, rs.getString(7), rs.getString(8));
				List.add(accDetail);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return List;
	}

	public boolean updateUserDetailAdmin(String email1, long mobilenumber, String email) throws SQLException {
		String updateQuery = "update user_details set email=? where email=?";
		String updatequery1 = "update account_details set email=?,mobile_number=? where email=?";
		Connection con = ConnectionUtil.getDbConnection();
		boolean flag = false;
		PreparedStatement statement=null;
		try {
			statement = con.prepareStatement(updatequery1);
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

		}finally {
			if(statement!=null)
			{
				statement.close();
			}
			if(con!=null)
			{
				con.close();
				 
			}
		}	
		return flag;
	}

	public boolean deleteDetails(long accountnum, String status) throws SQLException {
		String deleteQuery = "update account_details set account_status= ? where Account_number=?";
		Connection con = ConnectionUtil.getDbConnection();
		boolean flag = false;
		PreparedStatement statement=null;
		try {
			statement = con.prepareStatement(deleteQuery);
			statement.setString(1, status);
			statement.setLong(2, accountnum);
			statement.executeUpdate();
			flag = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			if(statement!=null)
			{
				statement.close();
			}
			if(con!=null)
			{
				con.close();
				 
			}
		}
		return flag;
	}

	public String getUserId(String email) throws SQLException {
		String query = "select user_id from Account_Details where email = ?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement statement=null;
		try {
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
		}finally {
			if(statement!=null)
			{
				statement.close();
			}
			if(con!=null)
			{
				con.close();
				 
			}
		}
		return null;
	}

	public int getPinnumber(long accountno) throws SQLException {
		String query = "select pin_number from Account_Details where account_number = ?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement statement =null;
		try {
			statement= con.prepareStatement(query);
			statement.setLong(1, accountno);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement!=null)
			{
				statement.close();
			}
			if(con!=null)
			{
				con.close();
				 
			}
		}
		return 0;
	}

	public double checkBalance(long accnum) {
		String que = "Select Balance from account_details where Account_number='" + accnum + "'";
		Connection con = ConnectionUtil.getDbConnection();
		double balance = 0;
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(que);
			if (rs.next()) {
				balance = rs.getDouble(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return balance;
	}

	public boolean checkaccount(long num) {
		String que = "select Account_number from account_details where account_number= '" + num + "'";
		boolean flag = false;
		long accnum = 0;
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(que);
			if (rs.next()) {
				accnum = rs.getLong(1);
				flag = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}
}
