package com.bankapp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.logger.Logger;


@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   {
		try {
		String email = request.getParameter("email");
		String email1 = request.getParameter("email1");
		long mobno=Long.parseLong( request.getParameter("mobno"));
		AccountDetailsdaoimpl accountDetailDao=new AccountDetailsdaoimpl();
		  accountDetailDao.updateUserDetailAdmin(email1,mobno, email);
           HttpSession session=request.getSession();
	       session.setAttribute("msg","Updated");
	       response.sendRedirect("updateAccountDetails.jsp");
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}

}
