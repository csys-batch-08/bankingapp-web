package com.bankapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.model.AccountDetails;

 
@WebServlet("/ViewAllAccount")
public class ViewAllAccount extends HttpServlet {
	 
	protected void  service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  AccountDetailsdaoimpl UserDao = new AccountDetailsdaoimpl();
        List<AccountDetails>  list = UserDao.viewAccout();
        request.setAttribute("ViewAccount",list);
        RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
        rd.forward(request, response);


	}

}
