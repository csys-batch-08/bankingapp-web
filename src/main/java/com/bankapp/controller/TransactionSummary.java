package com.bankapp.controller;
 
import java.util.List;

import javax.servlet.RequestDispatcher;
 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.Transaction;
 
@WebServlet("/account")
public class TransactionSummary extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   {
		   try {
		long accNo=Long.parseLong(request.getParameter("accno"));
		 
		 TransactionDaoimpl transDao=new TransactionDaoimpl();
		 transDao.getByAccountNumberAdmin(accNo);
		 HttpSession session=request.getSession();
		 session.setAttribute("accNo",accNo);
		  
	      TransactionDaoimpl tranDao = new TransactionDaoimpl();
	     long acc=(Long) session.getAttribute("accNo");
	        List<Transaction> list = tranDao.getByAccountNumberAdmin(acc);
	        request.setAttribute("transacAcc",list);
	        RequestDispatcher rd=request.getRequestDispatcher("transactionAdminView.jsp");
	       rd.forward(request, response);
			 
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
		 
	}

}
