package com.bankapp.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.LoansDaoimpl;
import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.model.Loans;

/**
 * Servlet implementation class Personal
 */
@WebServlet("/Personal")
public class PersonalLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonalLoan() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoansDaoimpl loandao = new LoansDaoimpl();
		UserDetailsDaoimpl userdao = new UserDetailsDaoimpl();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user_id");
		String pass = (String) session.getAttribute("pass");

		String type = "Personal Loan";
		String name = request.getParameter("lname");
		String emailId = request.getParameter("email");
		LocalDate Date = LocalDate.parse(request.getParameter("dob"));
		long mobno = Long.parseLong(request.getParameter("mobno"));
		String address = request.getParameter("address");
		double amount = Double.parseDouble(request.getParameter("amountDeposit"));
		int period = Integer.parseInt(request.getParameter("period"));
		String pan = request.getParameter("pan");
		String Wtype = request.getParameter("Wtype");
		double rate_of_interest = 0;
		long accnum = 0;
		int n = 0;

		if (Wtype.matches("Tier-I")) {
			n = 1;
			rate_of_interest = loandao.getInterest(3.1);
		} else if (Wtype.matches("Tier-II")) {
			n = 1;
			rate_of_interest = loandao.getInterest(3.2);
		} else if (Wtype.matches("Self Employee")) {
			n = 1;
			rate_of_interest = loandao.getInterest(3.3);
		} else
			System.out.println("invalid Period");

		double numberOfPayments = period * 12;
		double rt = (rate_of_interest / (12 * 100));
		double r = Math.pow((1 + rt), numberOfPayments);
		double monthly_payment = Math.round(amount * rt * ((r) / (r - 1)));
		// long accNum=loandao.getAccNum(emailId);
		String status = "NotApproved";
		boolean flag = loandao.validateLoan(pan);
		boolean checkloan = loandao.validatePersonalLoan(pan);
		if (flag == false) {
			if (checkloan == false) {
				Loans loan = new Loans(0, name, Date, address, mobno, emailId, type, Wtype, amount, period,
						rate_of_interest, monthly_payment, status, pan);
				accnum = loandao.PersonalLoan(loan);
				session.setAttribute("loan", " Loan Requested");
				session.setAttribute("loan1", accnum);
				response.sendRedirect("PersonalLoan.jsp");
			} else {
				session.setAttribute("Ploan", "You have Already requested the Personal Loan!");
				response.sendRedirect("PersonalLoan.jsp");
			}
		} else {
			session.setAttribute("loanNot", "Oops!It seems already you have Loan from our bank...");

			response.sendRedirect("PersonalLoan.jsp");
		}
	}
}
