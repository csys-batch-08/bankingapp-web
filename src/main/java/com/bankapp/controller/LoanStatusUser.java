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
import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.logger.Logger;
import com.bankapp.model.Loans;

@WebServlet("/loanStatus")
public class LoanStatusUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			long accountNum = Long.parseLong(request.getParameter("accno"));
			LoansDaoimpl accDetailDao = new LoansDaoimpl();
			boolean flag = accDetailDao.viewOneLoan(accountNum);
			if (flag) {
				List<Loans> loanlist;

				loanlist = accDetailDao.viewStatusUser(accountNum);

				request.setAttribute("LoanStatus", loanlist);
				RequestDispatcher rd = request.getRequestDispatcher("loanStatusView.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("laccnum", "Enter Valid Account Number!");
				response.sendRedirect("loanStatusUser.jsp");
			}
		} catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
