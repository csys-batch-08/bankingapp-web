 package com.bankapp.controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.DepositsDaoimpl;
 
@WebServlet("/FixedDeposit")
public class FixedDeposit extends HttpServlet {
 	private static final long serialVersionUID = 1L;
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
  	  try {
		DepositsDaoimpl depositdao=new DepositsDaoimpl();
		HttpSession session=request.getSession();
    		String type="FixedDeposit";
		    String status="NotApproved";
		    String pan=request.getParameter("pan");
		    String email=(String )session.getAttribute("user_id");
		double amount=Double.parseDouble(request.getParameter("amountDeposit"));
		int period=Integer.parseInt(request.getParameter("period"));
		 
		double rateOfInterest=0;
		int n=0;
	     if(period <=2) {
	    	   n=1;
	        rateOfInterest  = depositdao.getInterest(1.1);
	     }
	     else if(period >2) {
	    	  n=1;
	    	 rateOfInterest=depositdao.getInterest(1.2);
	     }
	     else
	    	 System.out.println("invalid Period");
	     double rt=(rateOfInterest/100);
	     double base=(1+( rt /n));
	     double  maturityValue=Math.round(amount * Math.pow(base,(n* period)));
	      
	 
		long accnum=depositdao.fixedDeposit(type, amount,rateOfInterest,maturityValue, period, status,pan,email) ;
		  
		 session.setAttribute("trans","Deposit Requested");
		 session.setAttribute("trans1","Deposit Account Number"+accnum);
		 	
					response.sendRedirect("FixedDeposit.jsp");
				} catch (Exception e) {
					 
					e.printStackTrace();
				}
		 }
		  
	

}
