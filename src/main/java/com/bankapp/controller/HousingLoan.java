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

@WebServlet("/House")
public class HousingLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			LoansDaoimpl loandao = new LoansDaoimpl();
			HttpSession session = request.getSession();
			String type = "Housing Loan";
			String status = "NotApproved";
			String wtype = "Home Loan";
			String name = request.getParameter("lname");
			String emailId = request.getParameter("email");
			LocalDate date = LocalDate.parse(request.getParameter("dob"));
			long mobno = Long.parseLong(request.getParameter("mobno"));
			String address = request.getParameter("address");
			double amount = Double.parseDouble(request.getParameter("amountDeposit"));
			int period = Integer.parseInt(request.getParameter("period"));
			String pan = request.getParameter("pan");
			double numberOfPayments = (period * 12);
			double rateOfInterest = 0;
			rateOfInterest = loandao.getInterest(3.3);
			double rt = (rateOfInterest / (12 * 100));
			double r = Math.pow((1 + rt), numberOfPayments);
			double monthlyPayment = Math.round(amount * rt * ((r) / (r - 1)));
			long accnum = 0;
			boolean flag = loandao.validateLoan(pan);
			boolean checkloan = loandao.validateHouseLoan(pan);
			if (flag) {
				if (checkloan) {
					session.setAttribute("Houloan", "You have already requested this loan!");
					response.sendRedirect("housingLoan.jsp");
				} else {

					Loans loan = new Loans(0, name, date, address, mobno, emailId, type, wtype, amount, period,
							rateOfInterest, monthlyPayment, status, pan);
					accnum = loandao.housingLoan(loan);
					session.setAttribute("Hloan", " Loan Requested");
					session.setAttribute("Hloan1", accnum);
					response.sendRedirect("housingLoan.jsp");
				}
			} else {
				session.setAttribute("HloanNot", "Oops!It seems already you have Loan from our bank...");
				response.sendRedirect("housingLoan.jsp");
			}
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}

}
