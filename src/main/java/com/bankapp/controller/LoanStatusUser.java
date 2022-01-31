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
import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.model.Loans;
 
 
@WebServlet("/loanStatus")
public class LoanStatusUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			long accNo = Long.parseLong(request.getParameter("accno"));
			LoansDaoimpl accDetailDao = new LoansDaoimpl();
			boolean flag = accDetailDao.ViewOneLoan(accNo);
			if (flag) {
				List<Loans> accde = accDetailDao.viewStatusUser(accNo);
				request.setAttribute("LoanStatus", accde);
				RequestDispatcher rd = request.getRequestDispatcher("loanStatusView.jsp");
				rd.forward(request, response);

			} else {
				session.setAttribute("laccnum", "Enter Valid Account Number!");
				RequestDispatcher rd = request.getRequestDispatcher("loanStatusView.jsp");
				rd.include(request, response);
			}
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
	}
}
