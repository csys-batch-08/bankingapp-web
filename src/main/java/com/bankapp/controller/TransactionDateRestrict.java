package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.logger.Logger;

@WebServlet("/TransactionDateRestrict")
public class TransactionDateRestrict extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			TransactionDaoimpl transdao = new TransactionDaoimpl();
			LocalDate date = transdao.getDate();

			request.setAttribute("date", date);
			RequestDispatcher rd = request.getRequestDispatcher("transactionByDate.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}

}
