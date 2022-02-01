package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.model.Deposits;
@WebServlet("/deposit")
public class DepositStatusUser extends HttpServlet {
 	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			long accNo = Long.parseLong(request.getParameter("accno"));
			DepositsDaoimpl accDetailDao = new DepositsDaoimpl();
			boolean flag;
			 
				flag = accDetailDao.viewOnedeposit(accNo); 
            if (flag) {
				List<Deposits> accde = accDetailDao.viewStatusUser(accNo);
				request.setAttribute("Deposits", accde);
				RequestDispatcher rd = request.getRequestDispatcher("depStatusView.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("Saccnum", "Enter Valid Account Number!");
				RequestDispatcher rd = request.getRequestDispatcher("depStatusView.jsp");
				rd.include(request, response);
			}
		} catch (ServletException | IOException |SQLException e) {

			e.printStackTrace();
		} 

}
}
