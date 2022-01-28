package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.impl.UserDetailsDaoimpl;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String email=request.getParameter("userId");
		String password=request.getParameter("pwd");
		long mobileNo=(Long.parseLong(request.getParameter("mobNo")));
		 
		UserDetailsDaoimpl userDetailDao=new  UserDetailsDaoimpl();
		AccountDetailsdaoimpl accountsDao = new AccountDetailsdaoimpl();
		try {
			String id = accountsDao.getUserId(email);
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		 
		userDetailDao.forgotPassword(password, email);
		response.sendRedirect("login.jsp");
	}

}
