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
	
	public int insertUser(UserDetails user) {
		String insertQuery = "insert into USER_DETAILS(USER_NAME,EMAIL,USER_PASSWORD,MOBILE_NUMBER) VALUES (?,?,?,?)";
        
		Connection con = ConnectionUtil.getDbConnection();
		int i=0;

		try {
			PreparedStatement	pst = con.prepareStatement(insertQuery);
			pst.setString(1, user.getusername());
			pst.setString(2, user.getEmailId());
			pst.setString(3, user.getuserpassword());
			pst.setLong(4, user.getmobileNumber());
			 
			i=pst.executeUpdate();
			System.out.println("Value Inserted Successfully");
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted");

		}
		return i;
	}
	public List<UserDetails> MyProfile(String email){
		List<UserDetails> userList=new ArrayList<UserDetails>();
		String view="select * from User_details where  email='"+email+"'";
		Connection con=ConnectionUtil.getDbConnection();
		 try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(view);
			while(rs.next()) {
				UserDetails user=new UserDetails( 0, rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5) );
				userList.add(user);
			//	System.out.println(userList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}

	public UserDetails validateUser(String emailId, String password) {
		String ValidateQuery = "select * from USER_DETAILS where role='USER' and email='" + emailId + "' and user_password='"
				+ password + "'";
		Connection con = ConnectionUtil.getDbConnection();
		UserDetails user = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(ValidateQuery);
			if (rs.next()) {
				user = new UserDetails(rs.getInt(1), rs.getString(2), emailId, password, rs.getLong(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		return user;
	}
	
	public UserDetails validatePassword(String emailId,  long mobno) {
		String ValidateQuery = "select * from USER_DETAILS where role='USER' and email='" + emailId + "' and mobile_number='"
				+ mobno + "'";
		Connection con = ConnectionUtil.getDbConnection();
		UserDetails user = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(ValidateQuery);
			if (rs.next()) {
				user = new UserDetails(rs.getInt(1), rs.getString(2), emailId, rs.getString(3), mobno);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		return user;
	}

	public  boolean updateUser(String name,String password,String email) {

		String updatequery1 = "update user_details set user_name=?,user_password=? where email=?";
		Connection con = ConnectionUtil.getDbConnection();
        boolean flag=false;
		try {
			PreparedStatement pstmt = con.prepareStatement(updatequery1);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			pstmt.setString(3,email);
			int i = pstmt.executeUpdate();
			 flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
			 
		}
		 return flag;
	}
	public  boolean forgotPassword( String password,String email) {

		String updatequery1 = "update user_details  set user_password=? where email=?";
		Connection con = ConnectionUtil.getDbConnection();
        boolean flag=false;
		try {
			PreparedStatement pstmt = con.prepareStatement(updatequery1);
			
			pstmt.setString(1,password);
			pstmt.setString(2,email);
			int i = pstmt.executeUpdate();
		 
			 flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		 
		}
		 return flag;
	}

	public UserDetails admin(String email_id, String password) {
		String AdminQuery = "select * from user_details where role='ADMIN' and email='" + email_id + "'and user_password='"
				+ password + "'";

		Connection con = ConnectionUtil.getDbConnection();
		UserDetails user1 = null;
		 
			Statement stm;
			try {
				stm = con.createStatement();
				ResultSet rs = stm.executeQuery(AdminQuery);
				if (rs.next()) {
					user1 = new UserDetails(rs.getInt(1), rs.getString(2), email_id, password, rs.getLong(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return user1;
	}
	public List<UserDetails> viewUser(){
		List<UserDetails> userList=new ArrayList<UserDetails>();
		String view="select User_login_id,user_name,email,mobile_number from User_details where role='USER'";
		Connection con=ConnectionUtil.getDbConnection();
		 try {
			 
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(view);
			while(rs.next()) {
				 
				UserDetails user=new UserDetails(rs.getInt(1), rs.getString(2), rs.getString(3), null,rs.getLong(4) );
				userList.add(user);
				 
			}
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}
		
		return userList;
	}
	public  boolean deleteDetails(String email) {
		String deleteQuery="update user_details set role='Inactive' where email=?";
		Connection con=ConnectionUtil.getDbConnection();
		boolean flag=false;
		 try {
			PreparedStatement pst= con.prepareStatement(deleteQuery);
		//	pst.setString(1, role);
			pst.setString(1, email);
			int i=pst.executeUpdate();
		   flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return flag;
	}

	 
	
		 
	}

