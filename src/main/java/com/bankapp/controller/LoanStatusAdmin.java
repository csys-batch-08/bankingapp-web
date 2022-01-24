package com.bankapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.Transaction;

/**
 * Servlet implementation class LoanStatusAdmin
 */
@WebServlet("/approveloan")
public class LoanStatusAdmin extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession();
		long accNo = Long.parseLong(request.getParameter("accno"));
		String status = request.getParameter("status");
		// System.out.println("hello "+accNo);
		LoansDaoimpl accDetailDao = new LoansDaoimpl();

		session.setAttribute("useraccno", accNo);

		accDetailDao.updateStatus(accNo, status);
		session.setAttribute("depo", "UPDATED");

		response.sendRedirect("ApproveLoans.jsp");
	}
 
	
}
