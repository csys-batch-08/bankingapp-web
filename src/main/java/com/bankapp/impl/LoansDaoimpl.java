package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.dao.LoansDao;
import com.bankapp.model.Deposits;
import com.bankapp.model.Loans;
import com.bankapp.model.UserDetails;
import com.bankapp.util.ConnectionUtil;

public class LoansDaoimpl implements LoansDao {
	public    double getInterest(double descriptionId) {
		 String updatequery1 = "select INTEREST_RATE from ADMIN_USE where DESCRIPTION_ID=?";
		Connection con = ConnectionUtil.getDbConnection();
		ResultSet rs = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(updatequery1);
			 
			pstmt.setDouble(1,descriptionId);
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getDouble("INTEREST_RATE");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	 }
	public   long PersonalLoan(Loans loan) {
	//	System.out.println(userid);
		String que="select  loan_acc.nextval from dual";
		String query="INSERT INTO LOANS (ACCOUNT_NUMBER,ACC_HOLDER_NAME,DOB,ADDRESS,MOBILE_NUMBER,EMAIL,LOAN_TYPE,DESCRIPTION,LOAN_AMOUNT,TENURE,INTEREST_RATE,MONTHLY_PAYMENT,LOAN_STATUS,PAN_NUMBER)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection con = ConnectionUtil.getDbConnection();
		 long accNumber = 0;
		 boolean flag=false;
		 
			
		 try {
			 PreparedStatement pstmt =  con.prepareStatement(que);
			 
			 pstmt.executeUpdate();
				ResultSet rs = pstmt.executeQuery();
				 
				if(rs.next()) {
					 accNumber = rs.getLong(1);
				}
			 
			    pstmt = con.prepareStatement(query);		  
			     
				pstmt.setLong(1, accNumber);
				pstmt.setString(2,loan. getUsername());
				pstmt.setDate(3,java.sql.Date.valueOf(loan.getDob()));
				pstmt.setString(4,loan.getAddress());
				pstmt.setLong(5,loan.getMobno());
				pstmt.setString(6,loan.getEmail());
				pstmt.setString(7,loan.getLoanType());
				pstmt.setString(8,loan.getDescription());
				pstmt.setDouble(9 ,loan. getLoanAmount());
				pstmt.setDouble(10,loan.getTenure());
				pstmt.setDouble(11,loan. getInterestRate());
				pstmt.setDouble(12,loan. getMonthlyPayment());
				pstmt.setString(13,loan. getLoanStatus());
				pstmt.setString(14,loan.getPanNumber());
				pstmt.executeUpdate();
				 
			 flag=true;
		 }catch (SQLException e) {
			 
				e.printStackTrace();
			}
		 return accNumber;
		 
	}
	public  long getAccNum(String email) {
		String query="select Account_number from account_details where email='"+email+"'";
		long accNum=0;
		 Connection con = ConnectionUtil.getDbConnection();
		 
		 try {
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(query);
			if(rs.next()) {
				accNum=rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return  accNum;
		
	}
	public boolean validateLoan( String pan) {
	    String que="select  * from loans where  pan_number='"+pan+"'  ";
	    String query="select  * from loans where  pan_number='"+pan+"' and Loan_status='Rejected' or Loan_status='NotApproved' ";
	    Connection con = ConnectionUtil.getDbConnection();
	    boolean flag=true;
	    try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(que);
			Statement st1=con.createStatement();
		 	ResultSet rs1=st1.executeQuery(query);
			
			 if(rs.next()) {
//				 Loans loan=new Loans(rs.getLong(1), rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getLong(5),
//							rs.getString(6), rs.getString(7),rs.getString(8),rs.getDouble(9),rs.getInt(10), rs.getDouble(11),
////							rs.getDouble(12), rs.getString(13), rs.getString(14));
				  
				 //flag=true;
				 if(rs1.next()) {
					   flag=false;
					   System.out.println("success");
				   }
				 
			 }
			 else {
				 flag=false;
			 }
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    
		return flag;
	}
	public boolean validatePersonalLoan( String pan) {
	    String que="select  * from loans where  pan_number='"+pan+"' and Loan_type='Personal Loan'";
	    Connection con = ConnectionUtil.getDbConnection();
	    boolean flag=true;
	    try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(que);
		 
		  
			
			 if(rs.next()) {
//				 Loans loan=new Loans(rs.getLong(1), rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getLong(5),
//							rs.getString(6), rs.getString(7),rs.getString(8),rs.getDouble(9),rs.getInt(10), rs.getDouble(11),
////							rs.getDouble(12), rs.getString(13), rs.getString(14));
				  
				 flag=true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return flag;
	}
	public boolean validateHouseLoan( String pan) {
	    String que="select  * from loans where  pan_number='"+pan+"' and Loan_type='Housing Loan'";
	    Connection con = ConnectionUtil.getDbConnection();
	    boolean flag=true;
	    try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(que);
		 
		  
			
			 if(rs.next()) {
//				 Loans loan=new Loans(rs.getLong(1), rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getLong(5),
//							rs.getString(6), rs.getString(7),rs.getString(8),rs.getDouble(9),rs.getInt(10), rs.getDouble(11),
////							rs.getDouble(12), rs.getString(13), rs.getString(14));
				  
				 flag=true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return flag;
	}
	public  long housingLoan(Loans loan) {
		String que="select  loan_acc.nextval from dual";
		String query="INSERT INTO LOANS (ACCOUNT_NUMBER,ACC_HOLDER_NAME,DOB,ADDRESS,MOBILE_NUMBER,EMAIL,LOAN_TYPE,DESCRIPTION,LOAN_AMOUNT,TENURE,INTEREST_RATE,MONTHLY_PAYMENT,LOAN_STATUS,PAN_NUMBER)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		 long accNumber = 0;
		 boolean flag=false;
		 
			
		 try {
			 PreparedStatement pstmt =  con.prepareStatement(que);
			 
			 pstmt.executeUpdate();
				ResultSet rs = pstmt.executeQuery();
				//System.out.println(userid);
				//System.out.println("ghsgdjhsg");
				if(rs.next()) {
					 accNumber = rs.getLong(1);
				}
			//	System.out.println(accNumber);
			    pstmt = con.prepareStatement(query);		  
			     
				pstmt.setLong(1, accNumber);
				pstmt.setString(2,loan. getUsername());
				pstmt.setDate(3,java.sql.Date.valueOf(loan.getDob()));
				pstmt.setString(4,loan.getAddress());
				pstmt.setLong(5,loan.getMobno());
				pstmt.setString(6,loan.getEmail());
				pstmt.setString(7,loan.getLoanType());
				pstmt.setString(8,loan.getDescription());
				pstmt.setDouble(9 ,loan.getLoanAmount());
				pstmt.setDouble(10,loan.getTenure());
				pstmt.setDouble(11,loan.getInterestRate());
				pstmt.setDouble(12,loan.getMonthlyPayment());
				pstmt.setString(13,loan.getLoanStatus());
				pstmt.setString(14,loan.getPanNumber());
				pstmt.executeUpdate();
			 flag=true;
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return accNumber;
	}
	public List<Loans> viewloan(){
		List<Loans> loans=new ArrayList<Loans>();
		String view1="select * from LOANS  ";
		Connection con1=ConnectionUtil.getDbConnection();
		 try {
			Statement st=con1.createStatement();
			ResultSet rs=st.executeQuery(view1);
			while(rs.next()) {
				Loans loan=new Loans(rs.getLong(2), rs.getString(3),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getLong(6),
						rs.getString(7), rs.getString(11),rs.getString(12),rs.getDouble(13),rs.getInt(14), rs.getDouble(15),
						rs.getDouble(16), rs.getString(17), rs.getString(18));
				loans.add(loan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loans;
	}
	public boolean updateStatus(long  accnum,String status) {
		String que="UPDATE LOANS SET LOAN_STATUS= ? WHERE  Account_number=?";
		Connection con=ConnectionUtil.getDbConnection();
		boolean flag=false;
		 try {
			PreparedStatement pst = con.prepareStatement(que);
			
			pst.setString(1,status);
			pst.setLong(2,accnum);
			int i = pst.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return flag;
	}
	
	 
	
	public List<Loans> viewStatusUser(long accNo) {
		List<Loans> list = new ArrayList<Loans>();
		String query="select  * from loans where account_number='"+accNo+"'";
		Connection con = ConnectionUtil.getDbConnection();
		ResultSet rs=null;
		try {
			Statement pst=con.createStatement();
			 
			   rs= pst.executeQuery(query);
				
				while(rs.next()) {
					Loans dep=new Loans(rs.getLong(2), rs.getString(3),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getLong(6),
							rs.getString(7), rs.getString(11),rs.getString(12),rs.getDouble(13),rs.getInt(14), rs.getDouble(15),
							rs.getDouble(16), rs.getString(17), rs.getString(18));
					list.add(dep);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public  boolean  ViewOneLoan(long accnum) {
		List <Loans> loans = new ArrayList<>();
		String view1 = "select * from Loans  where account_number='"+accnum+"' ";
		Connection con1 = ConnectionUtil.getDbConnection();
		boolean flag=false;
		try {
			Statement st = con1.createStatement();
			ResultSet rs = st.executeQuery(view1);
			 if (rs.next()) {
				 Loans loan = new Loans( rs.getLong(2), rs.getString(3),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getLong(6),
							rs.getString(7), rs.getString(11),rs.getString(12),rs.getDouble(13),rs.getInt(14), rs.getDouble(15),
							rs.getDouble(16), rs.getString(17), rs.getString(18)) ;
				loans.add(loan);
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return  flag;
	}
	 

}
