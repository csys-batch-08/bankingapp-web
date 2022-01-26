package com.bankapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.model.UserDetails;

 
@WebServlet("/ViewAllUser")
public class ViewAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void  service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetailsDaoimpl userDao = new UserDetailsDaoimpl();
		List<UserDetails> list = userDao.viewUser();
		 
		request.setAttribute("AllUser",list);
		RequestDispatcher rd=request.getRequestDispatcher("viewAllUser.jsp");
		rd.forward(request, response);
//		response.sendRedirect("viewAllUser.jsp");
	}

}
