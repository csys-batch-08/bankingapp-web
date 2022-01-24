package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String email = request.getParameter("email");
		String email1 = request.getParameter("email1");
		long mobno=Long.parseLong( request.getParameter("mobno"));
		AccountDetailsdaoimpl accountDetailDao=new AccountDetailsdaoimpl();
		accountDetailDao.updateUserDetailAdmin(email1,mobno, email);
		
		
		HttpSession session=request.getSession();
		 session.setAttribute("msg","updated");
		  response.sendRedirect("UpdateAccountDetails.jsp");
	
	}

}
