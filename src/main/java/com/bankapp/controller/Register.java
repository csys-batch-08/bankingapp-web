package com.bankapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.model.UserDetails;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			String name = request.getParameter("uname");
			String email = request.getParameter("emailId");

			String password = request.getParameter("pwd");
			String Cpassword = request.getParameter("Cpwd");
			long mobileNo = (Long.parseLong(request.getParameter("mobNo")));
			if (password.equals(Cpassword)) {
				UserDetailsDaoimpl userDetailDao = new UserDetailsDaoimpl();
				AccountDetailsdaoimpl accountsDao = new AccountDetailsdaoimpl();
				String id = accountsDao.getUserId(email);

				if (id != null) {
					int accountId = Integer.parseInt(id);
					UserDetails user = new UserDetails(name, email, password, mobileNo);
					userDetailDao.insertUser(user);
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}

				else {

					session.setAttribute("reg", "PLEASE ENTER YOUR REGISTERED ACCOUNT EMAILID");
					response.sendRedirect("register.jsp");

				}
			}

			else {
				session.setAttribute("reg", "Password and Confirm Password Must be same!");
				response.sendRedirect("register.jsp");
			}

		} catch (

		Exception e) {

			e.printStackTrace();
		}

	}
}
