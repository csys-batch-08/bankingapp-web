package com.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.model.AccountDetails;

/**
 * Servlet implementation class AccountDetail
 */
@WebServlet("/AccountDetails")
public class AccountDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
	 long accNo=Long.parseLong(request.getParameter("accNo"));
	    int pin=Integer.parseInt(request.getParameter("pin"));
	   AccountDetails accdao=new AccountDetails();
	   session.setAttribute("useraccno", accNo);
	   session.setAttribute("userpin", pin);
	   AccountDetailsdaoimpl accDetailDao=new AccountDetailsdaoimpl();
	   int pinnum=accDetailDao.getPinnumber(accNo);
		 if(pin==pinnum) {
	   List<AccountDetails> list = accDetailDao.searchDetail(accNo, pin);
	      response.sendRedirect("accDetailView.jsp");
		 }
		 else {
			 session.setAttribute("pinvalid", "Enter Valid Account number or Pin Number");
			 response.sendRedirect("accountDetail.jsp");
		 }
	}

}
