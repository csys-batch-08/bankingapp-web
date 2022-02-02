package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.Transaction;
 
@WebServlet("/transac")
public class TransactionSum extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			long accNo = Long.parseLong(request.getParameter("accno"));
			int pin = Integer.parseInt(request.getParameter("pin"));
			TransactionDaoimpl transDao = new TransactionDaoimpl();
			AccountDetailsdaoimpl accdao = new AccountDetailsdaoimpl();
			session.setAttribute("accNo", accNo);
			session.setAttribute("passw", pin);
			int pinnum = transDao.getPinnumber(accNo);
			boolean flag = accdao.checkaccount(accNo);
			 			if(flag){
			    if (pin == pinnum) {
				List<Transaction> list = transDao.getByAccountNumberUser(accNo, pin);
				request.setAttribute("TransacSummary", list);
				RequestDispatcher rd = request.getRequestDispatcher("transactionView.jsp");
                rd.forward(request, response);
			    } else {
				 session.setAttribute("pinum", "Enter Valid Pin Number");
				 response.sendRedirect("transactionSummary.jsp");
				 			 }
			}
			else
			{
				session.setAttribute("AccountNum", "Enter Valid Account Number");
				response.sendRedirect("transactionSummary.jsp");
				 
			}
		 } catch (ServletException | IOException | SQLException e) {
	    		e.printStackTrace();
		}

	}

}
