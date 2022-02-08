package com.bankapp.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.Transaction;

@WebServlet("/account")
public class TransactionSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			long accNo = Long.parseLong(request.getParameter("accno"));
			TransactionDaoimpl transDao = new TransactionDaoimpl();
			AccountDetailsdaoimpl accdetail = new AccountDetailsdaoimpl();
			boolean flag = accdetail.checkaccount(accNo);
			if (flag) {
				transDao.getByAccountNumberAdmin(accNo);
				session.setAttribute("accNo", accNo);
				long acc = (Long) session.getAttribute("accNo");
				List<Transaction> list = transDao.getByAccountNumberAdmin(acc);
				boolean res = list.isEmpty();
				if (res) {
					session.setAttribute("tranacc", "No Transaction To View");
					response.sendRedirect("transactionByAccount.jsp");
				} else {
					request.setAttribute("transacAcc", list);
					RequestDispatcher rd = request.getRequestDispatcher("transactionAdminView.jsp");
					rd.forward(request, response);

				}
			} else {
				session.setAttribute("tranaccount", "No Transaction To View");
				response.sendRedirect("transactionByAccount.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
