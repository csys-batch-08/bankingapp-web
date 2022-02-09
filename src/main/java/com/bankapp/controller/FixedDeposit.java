package com.bankapp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.logger.Logger;

@WebServlet("/FixedDeposit")
public class FixedDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			DepositsDaoimpl depositdao = new DepositsDaoimpl();
			TransactionDaoimpl transDao = new TransactionDaoimpl();
			HttpSession session = request.getSession();
			String type = "FixedDeposit";
			String status = "NotApproved";
			String pan = request.getParameter("pan");
			String email = (String) session.getAttribute("user_id");
			double amount = Double.parseDouble(request.getParameter("amountDeposit"));
			int period = Integer.parseInt(request.getParameter("period"));

			double rateOfInterest = 0;
			int n = 1;
			if (period <= 2) {

				rateOfInterest = depositdao.getInterest(1.1);
			} else if (period > 2) {

				rateOfInterest = depositdao.getInterest(1.2);
			}
			double rt = (rateOfInterest / 100);
			double base = (1 + (rt / n));
			double maturityValue = Math.round(amount * Math.pow(base, (n * period)));
			double balance = transDao.viewBalanceFd(pan);
			if (balance > amount) {
				long accnum = depositdao.fixedDeposit(type, amount, rateOfInterest, maturityValue, period, status, pan,
						email);
				session.setAttribute("trans", "Deposit Requested");
				session.setAttribute("trans1", "Deposit Number : " + accnum);
				response.sendRedirect("fixedDeposit.jsp");
			} else {
				session.setAttribute("fd", "Not enough Balance for applying Fixed Deposit");
				response.sendRedirect("fixedDeposit.jsp");
			}
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
