package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.model.UserDetails;

/**
 * Servlet implementation class RecurringDeposit
 */
 @WebServlet("/Recurring")
public class RecurringDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecurringDeposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);DepositsDaoimpl depositdao=new DepositsDaoimpl();
		DepositsDaoimpl depositdao=new DepositsDaoimpl();
		UserDetailsDaoimpl userdao=new UserDetailsDaoimpl();
		HttpSession session=request.getSession();
//		String userName=(String)session.getAttribute("user_id");
//		String pass=(String)session.getAttribute("pass");
//		
//		UserDetails validUser=userdao.validateUser(userName,pass );
//		 int user_id=validUser.getUser_id();
		String type="RecurringDeposit";
		   String status="NotApproved";
		   String pan=request.getParameter("pan");
		   String email=(String )session.getAttribute("user_id");
		double amount=Double.parseDouble(request.getParameter("amountDeposit"));
		int period=Integer.parseInt(request.getParameter("period"));
		double rate_of_interest=0;
		int n=0;
	     if(period <=2) {
	    	   n=1;
	        rate_of_interest  = depositdao.getInterest(2.1);
	     }
	     else if(period >2) {
	    	  n=1;
	    	 rate_of_interest=depositdao.getInterest(2.2);
	     }
	     else
	    	 System.out.println("invalid Period");
	     double rt=(rate_of_interest/100);
	     double base=(1+( rt /n));
	     double  maturity_value=Math.round(amount * Math.pow(base,(n* period)));
	     
		 
		depositdao.recurringDeposit(type, amount,rate_of_interest, period,maturity_value, status,pan,email) ;
		// HttpSession session=request.getSession();
		  
		  
		 session.setAttribute("tran"," RD Requested");
		  response.sendRedirect("RecurringDeposit.jsp");
		 
		  
	}

}
