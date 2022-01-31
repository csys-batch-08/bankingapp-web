package com.bankapp.controller;
 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.DepositsDaoimpl;
 
 
 @WebServlet("/Recurring")
public class RecurringDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		 try { 
		DepositsDaoimpl depositdao=new DepositsDaoimpl();
	 
		HttpSession session=request.getSession();
 
		String type="RecurringDeposit";
		   String status="NotApproved";
		   String pan=request.getParameter("pan");
		   String email=(String )session.getAttribute("user_id");
		double amount=Double.parseDouble(request.getParameter("amountDeposit"));
		int period=Integer.parseInt(request.getParameter("period"));
		double rateOfInterest=0;
		int n=1;
	     if(period <=2) {
	    	   
	        rateOfInterest  = depositdao.getInterest(2.1);
	     }
	     else if(period >2) {
	    	  
	    	 rateOfInterest=depositdao.getInterest(2.2);
	     }
	  
	     double rt=(rateOfInterest/100);
	     double base=(1+( rt /n));
	     double  maturityValue=Math.round(amount * Math.pow(base,(n* period)));
	     depositdao.recurringDeposit(type, amount,rateOfInterest, period,maturityValue, status,pan,email) ;
		 session.setAttribute("tran"," RD Requested");
		 response.sendRedirect("recurringDeposit.jsp");
		} catch (Exception e) {
		 
			e.printStackTrace();
		}
		 
		  
	}

}
