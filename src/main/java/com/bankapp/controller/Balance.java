package com.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.TransactionDaoimpl;

/**
 * Servlet implementation class Balance
 */@WebServlet("/Balance")
public class Balance extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();
		 long accNo=Long.parseLong(request.getParameter("accno"));
		 int pin=Integer.parseInt(request.getParameter("pin"));
		  
		 
		 TransactionDaoimpl transDao=new TransactionDaoimpl();
		 int pinnum=transDao.getPinnumber(accNo);
		 if(pin==pinnum) {
		 double amoun=transDao.viewBalance(accNo,  pin);
		 
		 
		 session.setAttribute( "amount", amoun);
		  response.sendRedirect("BalanceView.jsp");
		 }
		 else
		 {
			 session.setAttribute("pinvalidate","Enter Correct Pin Number");
			 response.sendRedirect("Balance.jsp");
		 }
		// PrintWriter out=response.getWriter();
		// out.println("Balance is :"+amoun);
		//  response.sendRedirect("TransferAmount.jsp");
	}

}
