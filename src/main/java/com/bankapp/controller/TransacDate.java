package com.bankapp.controller;

import java.time.LocalDate;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.Transaction;

@WebServlet("/date")
public class TransacDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String date = request.getParameter("date");
			LocalDate local = LocalDate.parse(date);

			HttpSession session = request.getSession();
			session.setAttribute("Date", local);
			TransactionDaoimpl tranDao = new TransactionDaoimpl();
			List<Transaction> list = tranDao.getbyDate(local);
			boolean res = list.isEmpty();

			if (res == false) {
				request.setAttribute("ViewList", list);
				RequestDispatcher rd = request.getRequestDispatcher("transactionDateView.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("trandate", "No Transaction To View");
				response.sendRedirect("transactionByDate.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
