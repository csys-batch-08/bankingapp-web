package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AdminUseDaoimpl;
import com.bankapp.impl.DepositsDaoimpl;

/**
 * Servlet implementation class RateServlet
 */
 @WebServlet("/interestRate")
public class RateServlet extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		AdminUseDaoimpl adminDao=new AdminUseDaoimpl();
		   double desc=Double.parseDouble(request.getParameter("desc"));
		   double rate=Double.parseDouble(request.getParameter("rate"));
		   adminDao. getDescriptionId(desc, rate);
		   HttpSession session=request.getSession();
		   session.setAttribute("rat","Updated");
			  response.sendRedirect("InterestRate.jsp");
	}

}
