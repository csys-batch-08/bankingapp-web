package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.ContactUsDaoimpl;

/**
 * Servlet implementation class ContactUs
 */
@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String message=request.getParameter("message");
		
		 ContactUsDaoimpl contact=new  ContactUsDaoimpl();
		 contact.insertMessage(name,email,message);
		 
		 HttpSession session=request.getSession();
		 session.setAttribute( "msg", "THANKYOU FOR YOUR RESPONSE!" );
		  response.sendRedirect("ContactUs.jsp");
	}

}
