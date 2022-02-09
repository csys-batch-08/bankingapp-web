package com.bankapp.controller;

import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.logger.Logger;
import com.bankapp.model.Loans;

@WebServlet("/Personal")
public class PersonalLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			LoansDaoimpl loandao = new LoansDaoimpl();
			HttpSession session = request.getSession();
			String type = "Personal Loan";
			String name = request.getParameter("lname");
			String emailId = request.getParameter("email");
			LocalDate date = LocalDate.parse(request.getParameter("dob"));
			long mobno = Long.parseLong(request.getParameter("mobno"));
			String address = request.getParameter("address");
			double amount = Double.parseDouble(request.getParameter("amountDeposit"));
			int period = Integer.parseInt(request.getParameter("period"));
			String pan = request.getParameter("pan");
			String wtype = request.getParameter("Wtype");
			double salary = Double.parseDouble(request.getParameter("salary"));
			double rateOfInterest = 0;
			long accnum = 0;
			int n = 1;

			if (wtype.matches("Tier-I")) {

				rateOfInterest = loandao.getInterest(3.1);
			} else if (wtype.matches("Tier-II")) {

				rateOfInterest = loandao.getInterest(3.2);
			} else if (wtype.matches("Self Employee")) {

				rateOfInterest = loandao.getInterest(3.3);
			}

			double numberOfPayments = (period * 12);
			double rt = (rateOfInterest / (12 * 100));
			double r = Math.pow((1 + rt), numberOfPayments);
			double monthlyPayment = Math.round(amount * rt * ((r) / (r - 1)));

			String status = "NotApproved";
			boolean flag = loandao.validateLoan(pan);
			boolean checkloan = loandao.validatePersonalLoan(pan);
			if (flag) {
				if (checkloan) {
					session.setAttribute("Ploan", "You have Already requested the Personal Loan!");
					response.sendRedirect("personalLoan.jsp");

				} else {
					Loans loan = new Loans(0, name, date, address, mobno, emailId, type, wtype, amount, period,
							rateOfInterest, monthlyPayment, status, pan, salary);
					accnum = loandao.PersonalLoan(loan);
					session.setAttribute("loan", " Loan Requested");
					session.setAttribute("loan1", accnum);

					response.sendRedirect("personalLoan.jsp");
				}
			} else {
				session.setAttribute("loanNot", "Oops!It seems already you have Loan from our bank...");

				response.sendRedirect("personalLoan.jsp");
			}
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
