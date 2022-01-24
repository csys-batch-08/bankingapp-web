package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.exception.IncorrectAccNumberException;
import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.impl.TransactionDaoimpl;

/**
 * Servlet implementation class TransferAmount
 */
@WebServlet("/TransferAmount")
public class TransferAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferAmount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		String uname=request.getParameter("uname");
		 long accNo=Long.parseLong(request.getParameter("accno"));
		 double amount=Double.parseDouble(request.getParameter("amount"));
		 int pin=Integer.parseInt(request.getParameter("pin"));
		 long Accno=Long.parseLong(request.getParameter("RecAccNo"));
		 AccountDetailsdaoimpl accdao=new AccountDetailsdaoimpl();
		 TransactionDaoimpl transDao=new TransactionDaoimpl();
		 int pinnum=transDao.getPinnumber(accNo);
		 double balance=accdao.checkBalance(accNo);
		 
		// System.out.println(balance);
		 boolean flag=accdao.checkaccount(Accno);
		 if(flag==true) {
			 if (amount>=300) {
		          if( amount < balance){
		              if(pin==pinnum) {
		                     transDao.depositAmount(accNo, uname, amount, pin, Accno);
		                    session.setAttribute("trans","TRANSFERRED");
		                   response.sendRedirect("TransferAmount.jsp");
		                              }
		 
		                     else {
		 
		                       session.setAttribute("trans","Enter  Correct Account number or Pin Number");
		                         response.sendRedirect("TransferAmount.jsp");
		                          }
		                 }
		           else {
			         session.setAttribute("trans","Not enough money to transfer!");
			          response.sendRedirect("TransferAmount.jsp");
		                 }
		            }
			 else {
				 
				  session.setAttribute("trans","Minimum Transaction Amount is 300! Please Transfer  More than 300");
		          response.sendRedirect("TransferAmount.jsp");
				 
			 }
		 }
		 else {
			 try {
			 session.setAttribute("trans","Verify Receiver Account Number ");
			  throw new IncorrectAccNumberException();
			 }catch(IncorrectAccNumberException e) {
				 response.sendRedirect(e.getMessage());
			 }
		 }
//		 session.setAttribute("useraccno", accNo);
//		 session.setAttribute("username", uname);
//		 session.setAttribute("amount", amount);
//		 session.setAttribute("userpin", pin);
//		 session.setAttribute("Recaccno", Accno);
		  // response.sendRedirect(" Transfer.jsp");
		    
	}

}
