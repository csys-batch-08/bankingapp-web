package com.bankapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.model.Deposits;

 
@WebServlet("/ApproveDeposit")
public class ApproveDeposit extends HttpServlet {
	 
	@Override
	protected void  service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		 
		DepositsDaoimpl depositDao = new DepositsDaoimpl();
		List<Deposits> list = depositDao.viewdeposit();
		request.setAttribute("ApproveDeposit",list);
		RequestDispatcher rd=request.getRequestDispatcher("ApproveDeposits.jsp");
		rd.forward(request, response);

		
	}

}
