package com.bankapp.controller;

import java.io.IOException;
 

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

     
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   {
		  try {
		String name=request.getParameter("uname");
		String email=request.getParameter("emailId");
		String password=request.getParameter("pwd");
		long mobileNo=(Long.parseLong(request.getParameter("mobNo")));
		 
		UserDetailsDaoimpl userDetailDao=new  UserDetailsDaoimpl();
		AccountDetailsdaoimpl accountsDao = new AccountDetailsdaoimpl();
		String id = accountsDao.getUserId(email);
		
		if( id !=null )
		{
			int accountId = Integer.parseInt(id);
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
		 
		  }catch (ServletException | IOException e) {
			 
			e.printStackTrace();
		}catch (Exception e) {
			 
			e.printStackTrace();
		}
		  
 		} 
	}


