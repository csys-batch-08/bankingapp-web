package com.bankapp.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.model.Loans;
import com.bankapp.model.UserDetails;

/**
 * Servlet implementation class HousingLoan
 */
@WebServlet("/House")
public class HousingLoan extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		LoansDaoimpl loandao=new LoansDaoimpl();
		UserDetailsDaoimpl userdao=new UserDetailsDaoimpl();
		HttpSession session=request.getSession();
		 
		String type="Housing Loan";
		String status="NotApproved";
		String Wtype="Home Loan";
		String name=request.getParameter("lname");
		String emailId=request.getParameter("email");
		LocalDate Date=LocalDate.parse(request.getParameter("dob"));
		long mobno=Long.parseLong(request.getParameter("mobno"));
		String address=request.getParameter("address");
		double amount=Double.parseDouble(request.getParameter("amountDeposit"));
		int period=Integer.parseInt(request.getParameter("period"));
		String pan= request.getParameter("pan");
		double numberOfPayments=period*12;
	    double  rate_of_interest=0;
		rate_of_interest  = loandao.getInterest(3.3);
	    double rt=(rate_of_interest/(12*100));
		double    r=Math.pow((1+rt), numberOfPayments);
	    double  monthly_payment= Math.round(amount *rt*((r)/(r-1)));
	    long accnum=0;
		 boolean flag=loandao.validateLoan(pan);
		 boolean checkloan = loandao.validateHouseLoan(pan);
	     if(flag==false) {
	    	 if (checkloan==false) {
	    		 
	    	 
	    	 Loans loan=new Loans(0,name,Date,address,mobno,emailId,type,Wtype,amount,period,rate_of_interest,monthly_payment,status,pan);
	    	 accnum=   loandao.housingLoan(loan);
			 session.setAttribute("Hloan"," Loan Requested");
			 session.setAttribute("Hloan1",accnum);
			 response.sendRedirect("HousingLoan.jsp");
	    	 }
	    	 else {
	    		 session.setAttribute("Houloan","You have already requested this loan!");
				 response.sendRedirect("HousingLoan.jsp");
	    	 }
	     }
	     else
	     {
	    	 session.setAttribute("HloanNot", "Oops!It seems already you have Loan from our bank...");
	    	  
	    	 response.sendRedirect("HousingLoan.jsp");
	     }
	}

}
