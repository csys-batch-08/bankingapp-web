package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.AdminUseDaoimpl;
import com.bankapp.model.AdminUse;

@WebServlet("/RateOfInterest")
public class RateOfInterest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			AdminUseDaoimpl admin = new AdminUseDaoimpl();

			List<AdminUse> adminList = admin.interestRate();
			request.setAttribute("rateInterest", adminList);
			RequestDispatcher rd = request.getRequestDispatcher("interest.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {

			e.printStackTrace();
		}

	}

}
