package com.bankapp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.TransactionDaoimpl;

@WebServlet("/Balance")
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			long accNo = Long.parseLong(request.getParameter("accno"));
			int pin = Integer.parseInt(request.getParameter("pin"));
			TransactionDaoimpl transDao = new TransactionDaoimpl();
			int pinnum = transDao.getPinnumber(accNo);
			if (pin == pinnum) {
				double amoun = transDao.viewBalance(accNo, pin);
				session.setAttribute("amount", amoun);
				response.sendRedirect("balanceView.jsp");
			} else {
				session.setAttribute("pinvld", "Enter Correct Pin Number");
				response.sendRedirect("balance.jsp");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
