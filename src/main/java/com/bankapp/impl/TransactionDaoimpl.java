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

import com.bankapp.dao.TransactionDao;
import com.bankapp.model.AccountDetails;
import com.bankapp.model.Transaction;
import com.bankapp.model.UserDetails;
import com.bankapp.util.ConnectionUtil;

public class TransactionDaoimpl implements TransactionDao {
	
	
	   public boolean depositAmount(long sender_AccNO, String Name, double amount, int pin_No, long receiver_AccNO) {
		Connection con = ConnectionUtil.getDbConnection();
		String rec_query = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = ? +(select balance from account_details where account_number=?) WHERE  ACCOUNT_NUMBER= ?  ";
		String rec_query1 = "select balance from account_details where account_number=?";
		double balance = 0;
		boolean flag=false;
		String rec_query2 = "insert into transaction (sender_account_number,name,transaction_type,receiver_account_number,amount,balance,transaction_status)values(?,?,'DEPOSIT AMOUNT',?,?,?,'CREDITED')";

		String send_query = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = (select balance from account_details where account_number=?)-? WHERE  ACCOUNT_NUMBER= ? AND PIN_NUMBER= ? ";
		

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(rec_query);

			ps.setDouble(1, amount);
			ps.setLong(2, receiver_AccNO);
			ps.setLong(3, receiver_AccNO);
			ps.executeUpdate();

			ps = con.prepareStatement(rec_query1);
			ps.setDouble(1, sender_AccNO );
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}

			ps = con.prepareStatement(rec_query2);
			ps.setLong(1, sender_AccNO);
			ps.setString(2, Name);
			ps.setLong(3, receiver_AccNO);
			ps.setDouble(4, amount);
			ps.setDouble(5, balance);
			ps.executeUpdate();
			ps = con.prepareStatement(send_query);

			ps.setLong(1, sender_AccNO);
			ps.setDouble(2, amount);
			ps.setLong(3, sender_AccNO);
			ps.setInt(4, pin_No);

			ps.executeUpdate();
			 flag=true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return flag;

	}

	public  boolean withdrawAmount(String name,long accountNo, double w_amount, int pinNo) {
		Connection con = ConnectionUtil.getDbConnection();
		String sql0 = "select balance from account_details where account_number=?";
         boolean flag=false;
		PreparedStatement pst;
		double balance = 0;
		try {
			pst = con.prepareStatement(sql0);
			pst.setLong(1, accountNo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}
			if (balance > w_amount) {
				double newbal = balance - w_amount;
				String sql = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = ? WHERE  ACCOUNT_NUMBER= ? AND PIN_NUMBER= ? ";
				String sql1 = "insert into transaction (sender_account_number,name,transaction_type,receiver_account_number,amount,balance,transaction_status)values(?,?,'WITHDRAW',?,?,?,'DEBITED')";
				pst = con.prepareStatement(sql);

				pst.setDouble(1, newbal);
				pst.setLong(2, accountNo);
				pst.setInt(3, pinNo);
				pst.executeUpdate();
			//	System.out.println("Amount debited from your account");
				pst = con.prepareStatement(sql1);
				pst.setLong(1, accountNo);
				pst.setString(2,name);
				pst.setLong(3, accountNo);
				pst.setDouble(4, w_amount);
				pst.setDouble(5, newbal);
				pst.executeUpdate();
				flag=true;
			}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public double viewBalance(long account_number, int pinNo) {
		Connection con = ConnectionUtil.getDbConnection();
		String query1 = "select BALANCE from account_details where Account_number=? and Pin_number=?";
		PreparedStatement pst;
		double balance = 0;
		try {

			pst = con.prepareStatement(query1);
			pst.setLong(1, account_number);
			pst.setInt(2, pinNo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
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
	public List<Transaction> getbyDate( LocalDate date) {
		Connection con=ConnectionUtil.getDbConnection();
		List<Transaction> list=new ArrayList<Transaction>();
		//System.out.println(date);
		  
		String query="select Sender_account_number,name,Transaction_type,Receiver_account_number,amount,transaction_status,transaction_date from transaction  where to_char(transaction_date,'yyyy-MM-dd')='"+date+"'  ";
		try {
			Statement st =con.createStatement();
			ResultSet rs= st.executeQuery(query);
			 
		    while(rs.next())
			{
		    	Transaction trans=new Transaction(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getDouble(5),
						rs.getString(6),rs.getDate(7).toLocalDate());
				list .add(trans);
			}
			 
	//	System.out.println(list);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	System.out.println(e);
		}
		return list;
	}
	public List<Transaction> getByAccountNumberAdmin(long accNo ) {
		Connection con=ConnectionUtil.getDbConnection();
		List<Transaction> list=new ArrayList<Transaction>();
		 ResultSet rs=null;
		String query=" select * from transaction  where  Sender_Account_number='"+accNo+"'";
		try {
			Statement st =con.createStatement();
		  rs= st.executeQuery(query);
			 
		    while(rs.next())
			{
		    	 
		    	Transaction transac=new Transaction(rs.getLong(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getDouble(6),
						rs.getString(7),rs.getDate(9).toLocalDate());
				list .add(transac);
			}
		//	 System.out.println(list);
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Transaction> getByAccountNumberUser(long accNo,int pin  ) {
		Connection con=ConnectionUtil.getDbConnection();
		List<Transaction> list=new ArrayList<Transaction>();
		 
		ResultSet  rs=null;
		String query="select * from transaction where  Sender_Account_number='"+accNo+"' order by transaction_date desc ";
		try {
			Statement pst=con.createStatement();
			rs= pst.executeQuery(query);
			
			while(rs.next())
			{
			Transaction	trans=new Transaction(rs.getLong(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getDouble(6),
					rs.getString(7),rs.getDate(9).toLocalDate());
			list .add(trans);
			}
		//	System.out.println(list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}

	 public LocalDate getDate()
	 {
		 String query="select trunc(Sysdate) from dual";
		 Connection con=ConnectionUtil.getDbConnection();
		 LocalDate date=null;
		 try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			if(rs.next()) {
				date=rs.getDate(1).toLocalDate();
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return date;
	 }
	
	
	
}
 