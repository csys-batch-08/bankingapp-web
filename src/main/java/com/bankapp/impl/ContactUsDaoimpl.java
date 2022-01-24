package com.bankapp.impl;
import com.bankapp.model.ContactUs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 
import com.bankapp.model.AdminUse;
import com.bankapp.util.ConnectionUtil;

public class ContactUsDaoimpl {

	public  boolean insertMessage(String name, String email, String message) {
            
           String query="insert into contact_us(user_name,email,message) values(?,?,?)";
           Connection con = ConnectionUtil.getDbConnection();
           boolean flag=false;
         	try {
         		PreparedStatement pstmt = con.prepareStatement(query);
         		pstmt.setString(1,name);
         		pstmt.setString(2,email);
         		pstmt.setString(3,message);
         		 flag=true;
         		int i = pstmt.executeUpdate();
         		 
         	} catch (SQLException e) {
         		e.printStackTrace();
         		 
         	}	
         	return flag;
	}
	public List<ContactUs> allDetails() {
		List<ContactUs> list=new ArrayList<ContactUs>();
		ConnectionUtil conUtil = new ConnectionUtil();
		
		String ValidateQuery="select * from  ContactUs ";
		 
		Connection con = conUtil.getDbConnection();
		 
		try {
			 Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(ValidateQuery);
				 
				while(rs.next())
				{
					ContactUs contact =new ContactUs(rs.getString(1),rs.getString(2),rs.getString(3));
					list.add(contact);
				}
				 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement Error");
		}
		
		return list;
	}
}
