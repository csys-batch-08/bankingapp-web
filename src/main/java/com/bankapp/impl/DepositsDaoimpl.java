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
	public double getInterest(double descriptionId) throws SQLException {
		String updatequery1 = "select INTEREST_RATE from ADMIN_USE where DESCRIPTION_ID=?";
		Connection con = ConnectionUtil.getDbConnection();
		ResultSet rs = null;
		PreparedStatement statement=null; 
		try {
			 statement = con.prepareStatement(updatequery1);
			statement.setDouble(1, descriptionId);
			rs = statement.executeQuery();
			if (rs.next())
				return rs.getDouble("INTEREST_RATE");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
    		if(statement!=null)
    		{
    			 statement.close();
    		}
    		if(true)
    		{
    			con.close();
       		}
    	}	
		return 0;
	}

	public long fixedDeposit(String type, double amount, double rateOfInterest, double maturityValue, int period,
			String status, String pan, String email) throws SQLException {
		Connection con = null;
		boolean flag = false;
		String querySelect = "select USER_ID,ACCOUNT_NUMBER FROM ACCOUNT_DETAILS WHERE EMAIL='"+email+"' and ACC_TYPE='FixedDeposit'";
		String query = "INSERT INTO DEPOSITS (ACCOUNT_NUMBER,USER_ID,DEPOSIT_TYPE,AMOUNT,TENURE_IN_YEARS,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS,PAN_NUMBER) VALUES(?,?,?,?,?,?,?,?,?,?)";
		LocalDate sysDate = LocalDate.now();
		Date mdate = Date.valueOf(sysDate.plusYears(period));
		long accNumber = 0;
		int userId = 0;
		PreparedStatement statement=null;
		Statement statement1=null;
		try {
			con = ConnectionUtil.getDbConnection();
           statement1=con.createStatement();
			ResultSet rs = statement1.executeQuery(querySelect);
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
			statement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}finally {
    		if(statement1!=null)
    		{
    			 statement1.close();
    		}
    		if(statement!=null)
    		{
    			statement.close();
    		}
    		if (con!=null)
    		{
    			con.close();
    			 
    		}
    	}	
		return accNumber;
	}

	public long recurringDeposit(String type, double amount, double rateOfInterest, int period, double maturityValue,
			String status, String pan, String email) throws SQLException {
		Connection con = ConnectionUtil.getDbConnection();
		String query = "select USER_ID,ACCOUNT_NUMBER FROM ACCOUNT_DETAILS WHERE EMAIL=? and ACC_TYPE='RecurringDeposit'";
		String queryInsert= "INSERT INTO DEPOSITS (ACCOUNT_NUMBER,USER_ID,DEPOSIT_TYPE,AMOUNT,TENURE_IN_YEARS,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS,PAN_NUMBER) VALUES(?,?,?,?,?,?,?,?,?,?)";
		boolean flag = false;
		LocalDate sysDate = LocalDate.now();
		Date mdate = Date.valueOf(sysDate.plusYears(period));
		long accNumber = 0;
		int userId = 0;
		PreparedStatement statement=null;
	
		try {

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
			statement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
	 
			e.printStackTrace();
		}finally {
    		if(statement!=null)
    		{
    			 statement.close();
    		}
    		 
    		if(true)
    		{
    			con.close();
    			 
    		}
    	}	
		return accNumber;
	}

	public List<Deposits> viewdeposit() throws SQLException {
		List<Deposits> loans = new ArrayList<>();
		String view1 = "select * from Deposits  ";
		Connection con =  null;
		Statement statement =null;
		try {
			con = ConnectionUtil.getDbConnection();
		    statement = con.createStatement();
			ResultSet rs = statement.executeQuery(view1);
			while (rs.next()) {
				Deposits loan = new Deposits(rs.getLong(1), rs.getLong(2),rs.getInt(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getDouble(8), rs.getDate(9).toLocalDate(),
						rs.getDouble(10), rs.getString(11),rs.getString(12) ,null);
				loans.add(loan);
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}    finally {		
			
			if(statement!=null)
		{
			 statement.close();
		}
		 
		if(con!=null)
		{
			con.close();
			 
		}
	  
	}	

		return loans;
	}

	public boolean viewOnedeposit(long accnum) throws SQLException {
		List<Deposits> loans = new ArrayList< >();
		String view1 = "select * from Deposits  where account_number='" + accnum + "' ";
		Connection con = null;
		Statement statement=null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(view1);
			if (rs.next()) {
				Deposits loan = new Deposits(rs.getLong(1), rs.getLong(2),rs.getInt(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getDouble(8), rs.getDate(9).toLocalDate(),
						rs.getDouble(10), rs.getString(11),rs.getString(12),rs.getDate(13).toLocalDate());
				loans.add(loan);
				flag = true;
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		} finally {		
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

	public boolean updateStatus(long depnum, String status) {
		String query = "select sysdate from dual ";
		String query1 = "select tenure_in_years from deposits where Deposit_number='" + depnum + "'";
		String que = "UPDATE DEPOSITS SET DEPOSIT_STATUS=?,maturity_date=? , Approved_date=? WHERE deposit_number=?";
		Connection con = ConnectionUtil.getDbConnection();
		int period = 0;
		PreparedStatement pst = null;
		LocalDate date = null;
		boolean flag = false;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				date = rs.getDate(1).toLocalDate();
				System.out.println(date);
			}
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(query1);
			if (rs1.next()) {
				period = rs1.getInt(1);
				System.out.println(period);
			}

			LocalDate sysDate = LocalDate.now();
			Date mdate = Date.valueOf(sysDate.plusYears(period));
			System.out.println("mdate" + mdate);
			pst = con.prepareStatement(que);
			pst.setString(1, status);
			pst.setDate(2, mdate);
			pst.setDate(3, java.sql.Date.valueOf(date));
//			System.out.println(java.sql.Date.valueOf(date));
//			System.out.println(mdate);
			pst.setLong(4, depnum);
			int i = pst.executeUpdate();
			if (i > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public List<Deposits> viewStatusUser(long accNo) {
		List<Deposits> list = new ArrayList<Deposits>();
		String query = "select  * from deposits where account_number='" + accNo + "'";
		Connection con = ConnectionUtil.getDbConnection();
		ResultSet rs = null;
		try {
			Statement pst = con.createStatement();

			rs = pst.executeQuery(query);

			while (rs.next()) {
				Deposits dep = new Deposits(rs.getLong(1), rs.getLong(2),rs.getInt(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getDouble(8), rs.getDate(9).toLocalDate(),
						rs.getDouble(10), rs.getString(11),rs.getString(12),rs.getDate(13).toLocalDate());
				list.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}
