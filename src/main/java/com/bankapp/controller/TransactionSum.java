package com.bankapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.Transaction;
 
@WebServlet("/transac")
public class TransactionSum extends HttpServlet {

	 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			long accNo = Long.parseLong(request.getParameter("accno"));
			int pin = Integer.parseInt(request.getParameter("pin"));
			TransactionDaoimpl transDao = new TransactionDaoimpl();

			HttpSession session = request.getSession();
			session.setAttribute("accNo", accNo);
			session.setAttribute("passw", pin);
			int pinnum = transDao.getPinnumber(accNo);
			if (pin == pinnum) {
				TransactionDaoimpl tranDao = new TransactionDaoimpl();
				List<Transaction> list = tranDao.getByAccountNumberUser(accNo, pin);
				request.setAttribute("TransacSummary", list);
				RequestDispatcher rd = request.getRequestDispatcher("transactionView.jsp");
                rd.forward(request, response);
			 } else {
				RequestDispatcher rd = request.getRequestDispatcher("transactionView.jsp");
				rd.include(request, response);
			 }
		 } catch (ServletException | IOException e) {
	    		e.printStackTrace();
		}

	}

}
