package com.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.model.UserDetails;

/**
 * Servlet implementation class login
 */
 @WebServlet("/login")
public class Login extends HttpServlet {
	 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		
		String userId=request.getParameter("userId");
		String password=request.getParameter("pwd");
		UserDetailsDaoimpl userDetailDao=new  UserDetailsDaoimpl();
		HttpSession session=request.getSession();
		UserDetails ValidAdmin=userDetailDao.admin(userId,password);
		UserDetails validUser =userDetailDao.validateUser(userId,password);
		
 
		if (validUser != null)
		   {
			 
			String name=validUser.getusername();
			
			session.setAttribute("user_id", userId);
			session.setAttribute("pass", password);
			session.setAttribute("username", name);
			 RequestDispatcher rd=request.getRequestDispatcher("CustomerDashBoard.jsp");
			   rd.forward(request, response);

			 
		   }
		 else if(ValidAdmin !=null) 
		 {
			 String admin= ValidAdmin.getusername() + " as Admin!" ;
			 session.setAttribute("adminname", admin);
			 RequestDispatcher rd=request.getRequestDispatcher("adminDashBoard.jsp");
			   rd.forward(request, response);


         }
		 else {
			 
			   session.setAttribute("login","Invalid User");
			    response.sendRedirect("login.jsp");
			  
		 }
	}
}