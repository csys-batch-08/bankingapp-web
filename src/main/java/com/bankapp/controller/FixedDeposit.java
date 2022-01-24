 package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.dao.UserDetailsDao;
import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.model.UserDetails;

/**
 * Servlet implementation class FixedDeposit
 */
@WebServlet("/FixedDeposit")
public class FixedDeposit extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		DepositsDaoimpl depositdao=new DepositsDaoimpl();
		UserDetailsDaoimpl userdao=new UserDetailsDaoimpl();
		HttpSession session=request.getSession();
		//String userName=(String)session.getAttribute("user_id");
	//	String pass=(String)session.getAttribute("pass");
		
	//	UserDetails validUser=userdao.validateUser(userName,pass );
	//	 int user_id=validUser.getUser_id();
		// System.out.println(user_id);
		String type="FixedDeposit";
		   String status="NotApproved";
		   String pan=request.getParameter("pan");
		   String email=(String )session.getAttribute("user_id");
		double amount=Double.parseDouble(request.getParameter("amountDeposit"));
		int period=Integer.parseInt(request.getParameter("period"));
		 
		double rate_of_interest=0;
		int n=0;
	     if(period <=2) {
	    	   n=1;
	        rate_of_interest  = depositdao.getInterest(1.1);
	     }
	     else if(period >2) {
	    	  n=1;
	    	 rate_of_interest=depositdao.getInterest(1.2);
	     }
	     else
	    	 System.out.println("invalid Period");
	     double rt=(rate_of_interest/100);
	     double base=(1+( rt /n));
	     double  maturity_value=Math.round(amount * Math.pow(base,(n* period)));
	     boolean flag=false;
	 
		long accnum=depositdao.fixedDeposit(type, amount,rate_of_interest,maturity_value, period, status,pan,email) ;
		  
		 session.setAttribute("trans","Deposit Requested");
		 session.setAttribute("trans1","Deposit Account Number"+accnum);
		 		  response.sendRedirect("FixedDeposit.jsp");
		 }
		  
	

}
