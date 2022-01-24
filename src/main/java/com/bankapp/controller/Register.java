package com.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.model.UserDetails;

/**
 * Servlet implementation class register
 */
 @WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
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
		//doGet(request, response);\
	//	System.out.println("hello");
		String name=request.getParameter("uname");
		String email=request.getParameter("emailId");
		String password=request.getParameter("pwd");
		long mobileNo=(Long.parseLong(request.getParameter("mobNo")));
		//System.out.println(name+email+password+mobileNo);
		UserDetailsDaoimpl userDetailDao=new  UserDetailsDaoimpl();
		AccountDetailsdaoimpl accountsDao = new AccountDetailsdaoimpl();
		String id = accountsDao.getUserId(email);
		
		if( id !=null )
		{
			int account_id = Integer.parseInt(id);
			UserDetails user = new UserDetails(name, email, password, mobileNo);
			userDetailDao.insertUser(user);		
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			   rd.forward(request, response);
		}

		else {
			HttpSession session=request.getSession();
			session.setAttribute("reg","PLEASE ENTER YOUR REGISTERED ACCOUNT EMAILID");
			response.sendRedirect("Reg.jsp");
			
		}
//		 UserDetails user=new UserDetails(name,email,password,mobileNo);
//		 userDetailDao.insertUser(user);
//		  Connection con = ConnectionUtil.getDbConnection();
		  
		   
//		 PrintWriter out=response.getWriter();
//		 out.print("welcome");
	}

}
