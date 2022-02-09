package com.bankapp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AdminUseDaoimpl;
import com.bankapp.logger.Logger;


 @WebServlet("/interestRate")
public class RateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   {
		try {
		AdminUseDaoimpl adminDao=new AdminUseDaoimpl();
		   double desc=Double.parseDouble(request.getParameter("desc"));
		   double rate=Double.parseDouble(request.getParameter("rate"));
		   adminDao. getDescriptionId(desc, rate);
		   HttpSession session=request.getSession();
		   session.setAttribute("rat","Updated");
			response.sendRedirect("interestRate.jsp");
			} catch (Exception e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
	}

}
