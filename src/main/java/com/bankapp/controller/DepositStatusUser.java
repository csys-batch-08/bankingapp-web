package com.bankapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.AccountDetails;
import com.bankapp.model.Deposits;
import com.bankapp.model.Transaction;

/**
 * Servlet implementation class depStatusUser
 */ @WebServlet("/deposit")
public class DepositStatusUser extends HttpServlet {
	 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();
		long accNo=Long.parseLong(request.getParameter("accno"));
		 DepositsDaoimpl accDetailDao=new DepositsDaoimpl();
		   boolean flag=accDetailDao.viewOnedeposit(accNo);
		   System.out.println(flag);
		   if (flag==true) {
		   List<Deposits> list = accDetailDao.viewStatusUser(accNo);
		   session.setAttribute("useraccno", accNo);
	//	   session.setAttribute("userpin", pin);
		   response.sendRedirect("depStatusView.jsp");
	                  }
		   else {
			   session.setAttribute("Saccnum","Enter Valid Account Number!");
			   response.sendRedirect("depositStatusUser.jsp");
		   }
		   
	}

}
