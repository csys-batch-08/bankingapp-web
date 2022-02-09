package com.bankapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.logger.Logger;

@WebServlet("/TransferAmount")
public class TransferAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  {
		try {
		HttpSession session = request.getSession();
		String uname = request.getParameter("uname");
		long accNo = Long.parseLong(request.getParameter("accno"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		int pin = Integer.parseInt(request.getParameter("pin"));
		long accNum = Long.parseLong(request.getParameter("RecAccNo"));
		AccountDetailsdaoimpl accdao = new AccountDetailsdaoimpl();
		TransactionDaoimpl transDao = new TransactionDaoimpl();
		int pinnum = transDao.getPinnumber(accNo);

		double balance = accdao.checkBalance(accNo);

		boolean flag = accdao.checkaccount(accNum);
		boolean flag1=accdao.checkaccount(accNo);
		if(flag1) {
		if (flag) {
			if (amount >= 300) {
				if (amount < balance) {
					if (pin == pinnum) {

						transDao.depositAmount(accNo, uname, amount, pin, accNum);
						transDao.updateBalance(accNo, amount, pinnum, accNum);
						session.setAttribute("transaction", "TRANSFERRED");
						 RequestDispatcher rd=request.getRequestDispatcher("transferAmount.jsp");
						 rd.include(request, response);
					  }
					else {
                         session.setAttribute("trans", "Enter  Correct   Pin Number");
						 response.sendRedirect("transferAmount.jsp");

					     }
				 }
				 else {
					session.setAttribute("trans", "Not enough money to transfer!");
					response.sendRedirect("transferAmount.jsp");

				      }
			  }
			  else {

				session.setAttribute("trans", "Minimum Transaction Amount is 300! Please Transfer  More than 300");
				response.sendRedirect("transferAmount.jsp");

				   }
		 }
		else {

				session.setAttribute("trans", "Verify Receiver  Account Number ");
				response.sendRedirect("transferAmount.jsp" );

		    }
		}
		else {
			session.setAttribute("trans", "Verify  Account Number ");
			response.sendRedirect("transferAmount.jsp");
		}
			} catch (Exception e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
		}


	}

}
