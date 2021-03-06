package com.bankapp.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.logger.Logger;
import com.bankapp.model.AccountDetails;

@WebServlet("/addAccount")
public class InsertAccount extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String accType = request.getParameter("accountType");
			String accHolderName = request.getParameter("accountHoldName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			int pincode = Integer.parseInt(request.getParameter("pincode"));
			LocalDate dob = LocalDate.parse(request.getParameter("date"));
			long mobNo = Long.parseLong(request.getParameter("mobile"));
			String email = request.getParameter("email");
			String ifscCode = request.getParameter("ifscCode");
			String branch = request.getParameter("branchName");
			double bal = Double.parseDouble(request.getParameter("balance"));
			int pin = Integer.parseInt(request.getParameter("pin"));
			String status = request.getParameter("status");
			String pan = request.getParameter("pan");
			AccountDetailsdaoimpl accdao = new AccountDetailsdaoimpl();
			AccountDetails acc = new AccountDetails(0, 0, accType, accHolderName, address, city, pincode, dob, mobNo,
					email, ifscCode, branch, bal, pin, status, pan);
			accdao.insertAccount(acc);
			List<AccountDetails> list = accdao.viewAccout();
			request.setAttribute("ViewAccount", list);
			RequestDispatcher rd = request.getRequestDispatcher("viewAccount.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}

}
