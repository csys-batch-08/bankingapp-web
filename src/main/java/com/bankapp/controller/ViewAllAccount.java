package com.bankapp.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.model.AccountDetails;

@WebServlet("/ViewAllAccount")
public class ViewAllAccount extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			AccountDetailsdaoimpl userDao = new AccountDetailsdaoimpl();
			List<AccountDetails> list = userDao.viewAccout();
			request.setAttribute("ViewAccount", list);
			RequestDispatcher rd = request.getRequestDispatcher("viewAccount.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
