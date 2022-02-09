package com.bankapp.controller;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.logger.Logger;
import com.bankapp.model.Loans;

@WebServlet("/ApproveLoans")
public class ApproveLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			LoansDaoimpl loanDao = new LoansDaoimpl();
			List<Loans> list = loanDao.viewloan();
			request.setAttribute("ApproveLoan", list);
			RequestDispatcher rd = request.getRequestDispatcher("approveLoans.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
