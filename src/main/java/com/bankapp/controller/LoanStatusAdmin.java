package com.bankapp.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.model.Loans;

@WebServlet("/approveloan")
public class LoanStatusAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			long accNo = Long.parseLong(request.getParameter("accno"));
			String status = request.getParameter("status");
			double salary = Double.parseDouble(request.getParameter("salary"));
			LoansDaoimpl accDetailDao = new LoansDaoimpl();
			accDetailDao.updateStatus(accNo, status);
			session.setAttribute("useraccno", accNo);
			double monthlyPayment = accDetailDao.checkAmount(accNo);
			if (salary > (10000 + monthlyPayment)) {
				System.out.println("sal" + salary);
				System.out.println("mp" + monthlyPayment);

				List<Loans> list = accDetailDao.viewloan();
				request.setAttribute("ApproveLoan", list);
				RequestDispatcher rd = request.getRequestDispatcher("approveLoans.jsp");
				rd.forward(request, response);

			} else {
				System.out.println("else");
				session.setAttribute("loanadmin",
						"Couldnot approve this loan..!Customer does not meet our  Eligiblity Criteria");
				List<Loans> list = accDetailDao.viewloan();
				request.setAttribute("ApproveLoan", list);
				RequestDispatcher rd = request.getRequestDispatcher("approveLoans.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
