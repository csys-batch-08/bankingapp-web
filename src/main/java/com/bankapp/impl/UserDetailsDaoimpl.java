package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bankapp.dao.UserDetailsDao;
import com.bankapp.logger.Logger;
import com.bankapp.model.UserDetails;
import com.bankapp.util.ConnectionUtil;

public class UserDetailsDaoimpl implements UserDetailsDao {
	private static final String EMAIL2 = "email";
	private static final String USER_PASSWORD = "user_password";
	private static final String USER_LOGIN_ID = "user_login_id";
	private static final String USER_NAME = "user_name";
	private static final String MOBILE_NUMBER = "mobile_number";

	@Override
	public int insertUser(UserDetails user) throws SQLException {
		String insertQuery = "insert into USER_DETAILS(USER_NAME,EMAIL,USER_PASSWORD,MOBILE_NUMBER) VALUES (?,?,?,?)";
		Connection con = null;
		PreparedStatement preStatement = null;
		int i = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			preStatement = con.prepareStatement(insertQuery);
			preStatement.setString(1, user.getusername());
			preStatement.setString(2, user.getEmailId());
			preStatement.setString(3, user.getuserpassword());
			preStatement.setLong(4, user.getmobileNumber());
			i = preStatement.executeUpdate();

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (preStatement != null)
				preStatement.close();
			if (con != null)
				con.close();
		}
		return i;
	}

	public List<UserDetails> myProfile(String email) throws SQLException {
		List<UserDetails> userList = new ArrayList<>();
		String userQuery = "select user_login_id,user_name,email,user_password,mobile_number from User_details where  email= ?";
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			preState = con.prepareStatement(userQuery);
			preState.setString(1, email);
			rs = preState.executeQuery();
			while (rs.next()) {
				UserDetails user = new UserDetails(rs.getInt(USER_LOGIN_ID), rs.getString(USER_NAME),
						rs.getString(EMAIL2), rs.getString(USER_PASSWORD), rs.getLong(MOBILE_NUMBER));
				userList.add(user);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, preState, con);
		}

		return userList;
	}

	@Override
	public UserDetails validateUser(String emailId, String password) throws SQLException {
		String validateQuery = "select user_login_id,user_name,email,user_password,mobile_number  from USER_DETAILS where role='USER' and email=? and user_password= ?";
		Connection con = null;
		PreparedStatement preStatement1 = null;
		ResultSet rs = null;
		UserDetails user = null;
		try {
			con = ConnectionUtil.getDbConnection();
			preStatement1 = con.prepareStatement(validateQuery);
			preStatement1.setString(1, emailId);
			preStatement1.setString(2, password);
			rs = preStatement1.executeQuery();
			if (rs.next()) {
				user = new UserDetails(rs.getInt(USER_LOGIN_ID), rs.getString(USER_NAME), rs.getString(EMAIL2),
						rs.getString(USER_PASSWORD), rs.getLong(MOBILE_NUMBER));
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			 ConnectionUtil.closeConnection(rs, preStatement1, con);
		}
		return user;
	}

	public UserDetails validatePassword(String emailId, long mobno) throws SQLException {
		String validateQuery = "select user_login_id,user_name,user_password from USER_DETAILS where role='USER' and email=? and mobile_number=?";
		Connection con = null;
		PreparedStatement prePareState = null;
		ResultSet rs = null;
		UserDetails user = null;
		try {
			con = ConnectionUtil.getDbConnection();
			prePareState = con.prepareStatement(validateQuery);
			prePareState.setString(1, emailId);
			prePareState.setLong(1, mobno);
			prePareState.executeUpdate();
			rs = prePareState.executeQuery(validateQuery);
			if (rs.next()) {
				user = new UserDetails(rs.getInt(USER_LOGIN_ID), rs.getString(USER_NAME), emailId,
						rs.getString(USER_PASSWORD), mobno);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
                ConnectionUtil.closeConnection(rs, prePareState, con);
		}
		return user;
	}

	@Override
	public boolean updateUser(String name, String password, String email) throws SQLException {

		String updateQuery = "update user_details set user_name=?,user_password=? where email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
			} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return flag;
	}

	public boolean forgotPassword(String password, String email) throws SQLException {

		String updateQuery = "update user_details  set user_password=? where email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return flag;
	}

	@Override
	public UserDetails admin(String emailId, String password) throws SQLException {
		String adminQuery = "select user_login_id,user_name,email,user_password,mobile_number from user_details where role='ADMIN' and email= ?and user_password=?";
		UserDetails user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(adminQuery);
			pstmt.setString(1, emailId);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserDetails(rs.getInt(USER_LOGIN_ID), rs.getString(USER_NAME), rs.getString(EMAIL2),
						rs.getString(USER_PASSWORD), rs.getLong(MOBILE_NUMBER));
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			 ConnectionUtil.closeConnection(rs, pstmt, con);
		}
		return user;
	}

	@Override
	public List<UserDetails> viewUser() throws SQLException {
		List<UserDetails> userList = new ArrayList<>();
		String viewQuery = "select User_login_id,user_name,email,mobile_number from User_details where role='USER' order by user_login_id";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.createStatement();
			rs = st.executeQuery(viewQuery);
			while (rs.next()) {

				UserDetails user = new UserDetails(rs.getInt("User_login_id"), rs.getString(USER_NAME),
						rs.getString(EMAIL2), null, rs.getLong(MOBILE_NUMBER));
				userList.add(user);

			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
		 ConnectionUtil.closeStatement(rs, st, con);
		}
		return userList;
	}

	@Override
	public boolean deleteDetails(String email) throws SQLException {
		String deleteQuery = "update user_details set role='Inactive' where email=?";
		Connection con = null;
		boolean flag = false;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(deleteQuery);
			pst.setString(1, email);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (con != null)
				con.close();
		}
		return flag;
	}

}
