package com.bankapp.controller;

import java.io.IOException;
 
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.AccountDetailsdaoimpl;
import com.bankapp.model.AccountDetails;

/**
 * Servlet implementation class AccountDetail
 */
@WebServlet("/AccountDetails")
public class AccountDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {

		HttpSession session = request.getSession();

		try {
			long accNo = Long.parseLong(request.getParameter("accNo"));
			int pin = Integer.parseInt(request.getParameter("pin"));

			session.setAttribute("useraccno", accNo);
			session.setAttribute("userpin", pin);
			AccountDetailsdaoimpl accDetailDao = new AccountDetailsdaoimpl();
			int pinnum = accDetailDao.getPinnumber(accNo);
			if (pin == pinnum) {
				List<AccountDetails>  accdet = accDetailDao.searchDetail(accNo, pin);
				 request.setAttribute("AccountDetail",accdet);
				 RequestDispatcher rd=request.getRequestDispatcher("accDetailView.jsp");
					rd.forward(request, response);
			 
			} else {
				session.setAttribute("pinvalid", "Enter Valid Account number or Pin Number");
				RequestDispatcher rd=request.getRequestDispatcher("accountDetail.jsp");
				rd.include(request, response);
			}
			
			 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		 

	}

}
