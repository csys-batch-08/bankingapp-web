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

import com.bankapp.impl.DepositsDaoimpl;

import com.bankapp.model.Deposits;

@WebServlet("/DepositApproveAdmin")
public class DepositApproveAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			long depNo = Long.parseLong(request.getParameter("accno"));
			String status = request.getParameter("status");
			DepositsDaoimpl depositsDao = new DepositsDaoimpl();

			double balance = depositsDao.checkBalanceAdmin(depNo);
			double amount = depositsDao.checkAmountAdmin(depNo);
			if (balance > amount) {
				depositsDao.updateStatus(depNo, status);
				List<Deposits> list = depositsDao.viewdeposit();
				request.setAttribute("ApproveDeposit", list);
				RequestDispatcher rd = request.getRequestDispatcher("approveDeposits.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("admin",
						"Couldnot Approve this Deposit because of Insufficient Balance in Customer Account");
				List<Deposits> list = depositsDao.viewdeposit();
				request.setAttribute("ApproveDeposit", list);
				RequestDispatcher rd = request.getRequestDispatcher("approveDeposits.jsp");
				rd.forward(request, response);
			}
		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}
	}

}
