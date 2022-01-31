package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.dao.AdminUseDao;
 
import com.bankapp.model.AdminUse;
import com.bankapp.util.ConnectionUtil;

public class AdminUseDaoimpl implements AdminUseDao {
public  boolean getDescriptionId(double descriptionId,double rateOfInterest) throws SQLException {
	String query="update admin_use set INTEREST_RATE=? where DESCRIPTION_ID=?";
	Connection con = ConnectionUtil.getDbConnection();
  boolean flag=false;
  PreparedStatement statement=null;
	try {
		 statement = con.prepareStatement(query);
		statement.setDouble(1,rateOfInterest);
		statement.setDouble(2,descriptionId);
		 flag=true;
		  statement.executeUpdate();
		 
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
	return flag;
}
public List<AdminUse> allDetails() throws SQLException {
	List<AdminUse> list=new ArrayList<>();
	Connection con = ConnectionUtil.getDbConnection();
	
	String validateQuery="select category_name,category_type,description,description_id,interest_rate from admin_use order by description_id";
	 
	 AdminUse adminuse=null;
	 Statement statement=null;
	try {
		   statement=con.createStatement();
			ResultSet rs=statement.executeQuery(validateQuery);
			 
			while(rs.next())
			{
				adminuse =new AdminUse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5));
				list.add(adminuse);
			}
			 
		
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
	return list;
}

public List<AdminUse> interestRate() throws SQLException {
	List<AdminUse> list=new ArrayList<>();
	Connection con = ConnectionUtil.getDbConnection();
	
	String validateQuery="select * from admin_use order by description_id";
	 
	 Statement statement=null;
	 AdminUse adminuse=null;
	try {
		   statement=con.createStatement();
			ResultSet rs=statement.executeQuery(validateQuery);
			 
			while(rs.next())
			{
				adminuse =new AdminUse(null,rs.getString(3),rs.getString(4),0,rs.getDouble(6));
				list.add(adminuse);
			}
			 
		
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
	
	return list;
}
 
}
	

