package com.bankapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.model.AccountDetails;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   {
		try {
		String email = request.getParameter("email");
		String email1 = request.getParameter("email1");
		long mobno=Long.parseLong( request.getParameter("mobno"));
		AccountDetailsdaoimpl accountDetailDao=new AccountDetailsdaoimpl();
		accountDetailDao.updateUserDetailAdmin(email1,mobno, email);
//		long  accnum= Long.parseLong(request.getParameter("acc"));
//		System.out.println(accnum);
//		   AccountDetailsdaoimpl userDao = new AccountDetailsdaoimpl();
//	        List<AccountDetails> list = userDao.viewOneAccount(accnum);
//	        System.out.println(list);
//	       request.setAttribute("UpdateAccount",list);
	       HttpSession session=request.getSession();
	       session.setAttribute("msg","Updated");
	       response.sendRedirect("UpdateAccountDetails.jsp");
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	
	}

}
