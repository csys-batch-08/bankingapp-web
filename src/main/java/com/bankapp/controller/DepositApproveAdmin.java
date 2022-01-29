package com.bankapp.controller;


import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bankapp.impl.DepositsDaoimpl;
 

@WebServlet("/DepositApproveAdmin")
public class DepositApproveAdmin extends HttpServlet {
 	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		  try {
		HttpSession session=request.getSession();
		long depNo=Long.parseLong(request.getParameter("accno"));
		String status=request.getParameter("status");
		 DepositsDaoimpl accDetailDao=new DepositsDaoimpl();
		 boolean list = accDetailDao.updateStatus(depNo,status);
		  session.setAttribute("useraccno", depNo);
          if(list) {
			   session.setAttribute("depo","UPDATED");
			   response.sendRedirect("ApproveDeposits.jsp");
          }
			} catch (IOException e) {
		 		e.printStackTrace();
			}		 
	}

}
