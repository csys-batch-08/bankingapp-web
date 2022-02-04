package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bankapp.dao.UserDetailsDao;
import com.bankapp.model.UserDetails;
import com.bankapp.util.ConnectionUtil;

public class UserDetailsDaoimpl implements UserDetailsDao {
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
			e.printStackTrace();
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
				UserDetails user = new UserDetails(rs.getInt("user_login_id"), rs.getString("user_name"),
						rs.getString("email"), rs.getString("user_password"), rs.getLong("mobile_number"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (preState != null)
				preState.close();
			if (con != null)
				con.close();
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
				user = new UserDetails(rs.getInt("user_login_id"), rs.getString("user_name"), rs.getString("email"),
						rs.getString("user_password"), rs.getLong("mobile_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (rs != null)
				rs.close();
			if (preStatement1 != null)
				preStatement1.close();
			if (con != null)
				con.close();

		}
		return user;
	}

	public UserDetails validatePassword(String emailId, long mobno) throws SQLException {
		String validateQuery1 = "select user_login_id,user_name,user_password from USER_DETAILS where role='USER' and email=? and mobile_number=?";
		Connection con = null;
		PreparedStatement preStatement2 = null;
		ResultSet rs = null;
		UserDetails user = null;
		try {
			con = ConnectionUtil.getDbConnection();
			preStatement2 = con.prepareStatement(validateQuery1);
			preStatement2.setString(1, emailId);
			preStatement2.setLong(1, mobno);
			preStatement2.executeUpdate();
			rs = preStatement2.executeQuery(validateQuery1);
			if (rs.next()) {
				user = new UserDetails(rs.getInt("user_login_id"), rs.getString("user_name"), emailId,
						rs.getString("user_password"), mobno);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (rs != null)
				rs.close();
			if (preStatement2 != null)
				preStatement2.close();
			if (con != null)
				con.close();
		}
		return user;
	}

	@Override
	public boolean updateUser(String name, String password, String email) throws SQLException {

		String updatequery1 = "update user_details set user_name=?,user_password=? where email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updatequery1);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return flag;
	}

	public boolean forgotPassword(String password, String email) throws SQLException {

		String updatequery2 = "update user_details  set user_password=? where email=?";
		Connection con = null;
		PreparedStatement pstmt1 = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt1 = con.prepareStatement(updatequery2);
			pstmt1.setString(1, password);
			pstmt1.setString(2, email);
			pstmt1.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (pstmt1 != null)
				pstmt1.close();
			if (con != null)
				con.close();
		}
		return flag;
	}

	@Override
	public UserDetails admin(String emailId, String password) throws SQLException {
		String adminQuery1 = "select user_login_id,user_name,email,user_password,mobile_number from user_details where role='ADMIN' and email= ?and user_password=?";
		UserDetails user1 = null;
		Connection con = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt1 = con.prepareStatement(adminQuery1);
			pstmt1.setString(1, emailId);
			pstmt1.setString(2, password);

			rs = pstmt1.executeQuery();
			if (rs.next()) {
				user1 = new UserDetails(rs.getInt("user_login_id"), rs.getString("user_name"), rs.getString("email"),
						rs.getString("user_password"), rs.getLong("mobile_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt1 != null)
				pstmt1.close();
			if (con != null)
				con.close();
		}

		return user1;
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

				UserDetails user = new UserDetails(rs.getInt("User_login_id"), rs.getString("user_name"),
						rs.getString("email"), null, rs.getLong("mobile_number"));
				userList.add(user);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
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

			e.printStackTrace();
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
