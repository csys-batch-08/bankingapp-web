package com.bankapp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.impl.TransactionDaoimpl;

@WebServlet("/Recurring")
public class RecurringDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			DepositsDaoimpl depositdao = new DepositsDaoimpl();
			TransactionDaoimpl transDao = new TransactionDaoimpl();
			HttpSession session = request.getSession();

			String type = "RecurringDeposit";
			String status = "NotApproved";
			String pan = request.getParameter("pan");
			String email = (String) session.getAttribute("user_id");
			double amount = Double.parseDouble(request.getParameter("monthlyDeposit"));
			int period = Integer.parseInt(request.getParameter("period"));
			double totalAmount = Double.parseDouble(request.getParameter("amountDeposit"));
			double rateOfInterest = 0;
			int n = 1;
			if (period <= 2) {

				rateOfInterest = depositdao.getInterest(2.1);
			} else if (period > 2) {

				rateOfInterest = depositdao.getInterest(2.2);
			}

			double rt = (rateOfInterest / 100);
			double base = (1 + (rt / n));
			double maturityValue = Math.round(totalAmount * Math.pow(base, (n * period)));
			double balance = transDao.viewBalanceFd(pan);
			if (amount < balance) {
				long accnum = depositdao.recurringDeposit(type, amount, rateOfInterest, period, maturityValue, status,
						pan, email, totalAmount);
				session.setAttribute("rd1", " RD Requested");
				session.setAttribute("rd2", "Deposit Number : " + accnum);
				response.sendRedirect("recurringDeposit.jsp");
			} else {
				session.setAttribute("rd", "Not enough Balance for applying Recurring Deposit");
				response.sendRedirect("recurringDeposit.jsp");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
