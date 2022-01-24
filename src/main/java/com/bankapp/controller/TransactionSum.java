package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.TransactionDaoimpl;

/**
 * Servlet implementation class TransactionSum
 */   
@WebServlet("/transac")
public class TransactionSum extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		long accNo=Long.parseLong(request.getParameter("accno"));
		 int pin=Integer.parseInt(request.getParameter("pin"));
		 TransactionDaoimpl transDao=new TransactionDaoimpl();
		
		 HttpSession session=request.getSession();
		 session.setAttribute("accNo",accNo);
		 session.setAttribute("passw", pin);
		 int pinnum=transDao.getPinnumber(accNo);
		 if(pin==pinnum) {
		 double amoun=transDao.viewBalance(accNo,  pin);
		 transDao.getByAccountNumberUser(accNo, pin);
		 
		 response.sendRedirect("TransactionView.jsp");
		 }
		 else
		 {
			 session.setAttribute("pinvalidate","Enter Correct Account Number or Pin Number");
			 response.sendRedirect("TransactionSummary.jsp");
		 }
		 
		 
	}

}
