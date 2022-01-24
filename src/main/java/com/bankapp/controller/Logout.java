package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/LogoutServlet")
public class Logout extends HttpServlet {
	 
	protected void  service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();
		session.setAttribute("out","LogoutSuccessfully");
         session.invalidate();
        request.getRequestDispatcher("login.jsp").forward(request, response);
       //  response.sendRedirect("login.jsp");
        
		
	}

}
