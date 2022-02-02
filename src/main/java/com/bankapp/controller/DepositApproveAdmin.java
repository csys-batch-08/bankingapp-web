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
import com.bankapp.impl.DepositsDaoimpl;
import com.bankapp.model.Deposits;
 
@WebServlet("/DepositApproveAdmin")
public class DepositApproveAdmin extends HttpServlet {
 	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		  try {
		 		long depNo=Long.parseLong(request.getParameter("accno"));
		        String status=request.getParameter("status");
		        DepositsDaoimpl depositsDao=new DepositsDaoimpl();
		        depositsDao.updateStatus(depNo,status);
		        List<Deposits> list = depositsDao.viewdeposit();
		        request.setAttribute("ApproveDeposit",list);
			    RequestDispatcher rd=request.getRequestDispatcher("approveDeposits.jsp");
		  	    rd.forward(request, response);
	   	       } catch (IOException |SQLException | ServletException  e) {
		 		e.printStackTrace();
			   }		 
	}

}
