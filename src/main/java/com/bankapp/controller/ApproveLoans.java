package com.bankapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.model.Loans;

/**
 * Servlet implementation class ApproveLoans
 */
@WebServlet("/ApproveLoans")
public class ApproveLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void  service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   LoansDaoimpl loanDao = new LoansDaoimpl();
		List<Loans> list = loanDao.viewloan();
		request.setAttribute("ApproveLoan",list);
		RequestDispatcher rd=request.getRequestDispatcher("ApproveLoans.jsp");
		rd.forward(request, response);
		
   }

}
