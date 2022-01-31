package com.bankapp.controller;

 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
 
@WebServlet("/Cancel")
public class UserCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   {
		try {
		 long accno=Long.parseLong(request.getParameter("accNo"));
		String status=request.getParameter("stat");
  		AccountDetailsdaoimpl userDetailDao=new  AccountDetailsdaoimpl();
	    userDetailDao.deleteDetails(accno,status);
		HttpSession session=request.getSession();
	  	session.setAttribute("can", "Updated");
	  	
			response.sendRedirect("userCancel.jsp");
		} catch (Exception e) {
		 
			e.printStackTrace();
		}
	}

}
