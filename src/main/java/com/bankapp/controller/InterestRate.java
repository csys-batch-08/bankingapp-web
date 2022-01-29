package com.bankapp.controller;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.impl.AdminUseDaoimpl;
import com.bankapp.model.AdminUse;

@WebServlet("/InterestRate")
public class InterestRate extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void  service(HttpServletRequest request, HttpServletResponse response)   {
		try {
			AdminUseDaoimpl adminDao = new AdminUseDaoimpl();
			List<AdminUse> list = adminDao.allDetails();
			
			 request.setAttribute("InterestsRate",list);
			 RequestDispatcher rd=request.getRequestDispatcher("InterestRateAll.jsp");
				
					rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

}
