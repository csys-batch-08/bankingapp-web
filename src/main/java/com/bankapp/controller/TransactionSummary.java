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
 * Servlet implementation class TransactionSummary
 */  
@WebServlet("/account")
public class TransactionSummary extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		long accNo=Long.parseLong(request.getParameter("accno"));
		 
		 TransactionDaoimpl transDao=new TransactionDaoimpl();
		 transDao.getByAccountNumberAdmin(accNo);
		 HttpSession session=request.getSession();
		 session.setAttribute("accNo",accNo);
				 
		 response.sendRedirect("TransactionAdminView.jsp");
		
	}

}
