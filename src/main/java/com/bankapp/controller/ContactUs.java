package com.bankapp.controller;

 

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.ContactUsDaoimpl;
 
@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
 	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		try {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String message=request.getParameter("message");
		ContactUsDaoimpl contact=new  ContactUsDaoimpl();
		 
			contact.insertMessage(name,email,message);
		 
          HttpSession session=request.getSession();
		  session.setAttribute( "msg", "THANKYOU FOR YOUR RESPONSE!" );
		  response.sendRedirect("contactUs.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
