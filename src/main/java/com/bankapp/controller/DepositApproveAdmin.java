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
import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.Deposits;
import com.bankapp.model.Transaction;

/**
 * Servlet implementation class DepositApproveAdmin
 */
@WebServlet("/DepositApproveAdmin")
public class DepositApproveAdmin extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();
		long depNo=Long.parseLong(request.getParameter("accno"));
		String status=request.getParameter("status");
		  
		 DepositsDaoimpl accDetailDao=new DepositsDaoimpl();
		// accDetailDao.getDepositNumber 
		   boolean list = accDetailDao.updateStatus(depNo,status);
		   session.setAttribute("useraccno", depNo);
	//	   session.setAttribute("userpin", pin);
		   
		   if(list) {
			   session.setAttribute("depo","UPDATED");
			 //  System.out.println("success");
			   response.sendRedirect("ApproveDeposits.jsp");
		   }
		   else {
			   //System.out.println("fail");
		   }
			 
	}

}
