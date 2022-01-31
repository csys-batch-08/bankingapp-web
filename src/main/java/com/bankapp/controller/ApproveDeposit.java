package com.bankapp.controller;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.model.Deposits;
@WebServlet("/ApproveDeposit")
public class ApproveDeposit extends HttpServlet {
 	private static final long serialVersionUID = 1L;
	@Override
	protected void  service(HttpServletRequest request, HttpServletResponse response)  {
		try {
		DepositsDaoimpl depositDao = new DepositsDaoimpl();
		List<Deposits> list = depositDao.viewdeposit();
		request.setAttribute("ApproveDeposit",list);
		RequestDispatcher rd=request.getRequestDispatcher("approveDeposits.jsp");
	
			rd.forward(request, response);
		} catch ( Exception e) {
			e.printStackTrace();
		} 
	}
}
