package com.bankapp.controller;
 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.LoansDaoimpl;

 
@WebServlet("/approveloan")
public class LoanStatusAdmin extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response){
		try {
		HttpSession session = request.getSession();
		long accNo = Long.parseLong(request.getParameter("accno"));
		String status = request.getParameter("status");
		 
		LoansDaoimpl accDetailDao = new LoansDaoimpl();

		session.setAttribute("useraccno", accNo);

		accDetailDao.updateStatus(accNo, status);
		session.setAttribute("depo", "UPDATED");
         response.sendRedirect("approveLoans.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	
}
