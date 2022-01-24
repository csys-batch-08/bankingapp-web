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
import com.bankapp.model.Loans;
import com.bankapp.model.Transaction;

/**
 * Servlet implementation class LoanStatusUser
 */
@WebServlet("/loanStatus")
public class LoanStatusUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanStatusUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		HttpSession session=request.getSession();
		long accNo=Long.parseLong(request.getParameter("accno"));
		LoansDaoimpl accDetailDao=new LoansDaoimpl();
		   boolean flag=accDetailDao.ViewOneLoan(accNo);
		   if (flag==true) {
		   List<Loans> list = accDetailDao.viewStatusUser(accNo);
		   session.setAttribute("useraccno", accNo);
	//	   session.setAttribute("userpin", pin);
		   response.sendRedirect("loanStatusView.jsp");
		   } else {
			   session.setAttribute("Saccnum","Enter Valid Account Number!");
			   response.sendRedirect("LoanStatusUser.jsp");
		   }
	}
	}

