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
    
	public  boolean insertAccount(AccountDetails account) {
		String que="select  user_id.nextval from dual";
		String query="INSERT INTO Account_details (USER_ID,ACC_TYPE,ACC_HOLDER_NAME,ADDRESS,CITY,PINCODE,DOB,MOBILE_NUMBER,EMAIL,IFSC_CODE,BRANCH_NAME,BALANCE,PIN_NUMBER,ACCOUNT_STATUS)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		 int accNumber = 0;
		 boolean flag=false;
			 
		 try {
			 PreparedStatement   pstmt = con.prepareStatement(que);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
					accNumber = rs.getInt(1);
			//	System.out.println(accNumber);
				pstmt = con.prepareStatement(query);	  
			    pstmt.setInt(1, accNumber);
				pstmt.setString(2,account.getAccount_type());
				pstmt.setString(3,account.getAccount_Holder_name());
				pstmt.setString(4,account.getAddress());
				pstmt.setString(5,account.getCity());
				pstmt.setInt(6,account.getPincode());
				pstmt.setDate(7,java.sql.Date.valueOf(account.getDob()));
				pstmt.setLong(8,account.getMobile_Number());
				pstmt.setString(9,account.getEmail());
				pstmt.setString(10,account.getIfsc_Code());
				pstmt.setString(11,account.getBranchName());
				pstmt.setDouble(12,account.getBalance());
				pstmt.setInt(13,account.getPin_Number());
				pstmt.setString(14,account.getStatus());
				pstmt.executeUpdate();
				flag=true;
			 
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return flag;
	}
	 

	public List<AccountDetails> searchDetail(long accNumber, int pinNumber) {
		List<AccountDetails> list = new ArrayList<AccountDetails>();
		ConnectionUtil conUtil = new ConnectionUtil();

		String ValidateQuery = "select * from ACCOUNT_DETAILS WHERE  ACCOUNT_NUMBER='" + accNumber
				+ "' and PIN_NUMBER='" + pinNumber + "'";

		Connection con = conUtil.getDbConnection();
		AccountDetails accDetail = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(ValidateQuery);

			if (rs.next()) {
				accDetail = new AccountDetails(rs.getInt(1),rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getDate(8).toLocalDate(), rs.getLong(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14),rs.getString(15),rs.getString(16));
				list.add(accDetail);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return list;
	}
	public List<AccountDetails> viewAccout(){
		List<AccountDetails> List=new ArrayList<AccountDetails>();
		
		String view="select * from  account_details";
		Connection con=ConnectionUtil.getDbConnection();
		 try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(view);
			while(rs.next()) {
				AccountDetails accDetail = new AccountDetails(rs.getInt(1),rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getDate(8).toLocalDate(), rs.getLong(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14),rs.getString(15),rs.getString(16));
				List.add(accDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return List;
	}
	public List<AccountDetails> viewOneAccount(long num){
		List<AccountDetails> List=new ArrayList<AccountDetails>();
		
		String view="select * from  account_details where account_num='"+num+"'";
		Connection con=ConnectionUtil.getDbConnection();
		 try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(view);
			if(rs.next()) {
				AccountDetails accDetail = new AccountDetails(rs.getInt(1),rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getDate(8).toLocalDate(), rs.getLong(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14),rs.getString(15),rs.getString(16));
				List.add(accDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return List;
	}
	public boolean updateUserDetailAdmin(String email1, long mobilenumber, String email) {

		String updatequery1 = "update account_details set email=?,mobile_number=? where email=?";
		Connection con = ConnectionUtil.getDbConnection();
        boolean flag=false;
		try {
			PreparedStatement pstmt = con.prepareStatement(updatequery1);
			pstmt.setString(1, email1);
			pstmt.setLong(2, mobilenumber);
			pstmt.setString(3, email);
			  pstmt.executeUpdate();
          flag=true;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return flag;
	}

	public boolean deleteDetails(long accountnum, String status) {
		String deleteQuery = "update account_details set account_status= ? where Account_number=?";
		Connection con = ConnectionUtil.getDbConnection();
		boolean flag=false;
		try {
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setString(1, status);
			pst.setLong(2, accountnum);
			pst.executeUpdate();
			flag=true;
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public String getUserId(String email) {
		String query = "select user_id from Account_Details where email = ?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString("user_id");
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public  int  getPinnumber(  long accountno)
	{
		String query = "select pin_number from Account_Details where account_number = ?";
		Connection con=ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pst= con.prepareStatement(query);
			pst.setLong(1, accountno  );
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}else {
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	 public double checkBalance(long accnum) {
		 String que="Select Balance from account_details where Account_number='"+accnum+"'";
				 Connection con=ConnectionUtil.getDbConnection();
		 double balance=0;
		 Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(que);
			if(rs.next()) {
				 balance= rs.getDouble(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return balance;
	 }
	 public boolean checkaccount(long num) {
		 String que="select Account_number from account_details where account_number= '"+num+"'";
		 boolean flag=false;
		 long accnum=0;
		 Connection con=ConnectionUtil.getDbConnection();
		 try {
			Statement st = con.createStatement();
				ResultSet rs=st.executeQuery(que);
				if(rs.next()) {
					  accnum= rs.getLong(1);
					  flag=true;
				}
		 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return flag;
	 }
}
