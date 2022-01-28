package com.bankapp.controller;

import java.io.IOException;
import java.time.LocalDate;
 
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.impl.TransactionDaoimpl;
import com.bankapp.model.Transaction;

/**
 * Servlet implementation class TransacDate
 */
@WebServlet("/date")
public class TransacDate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
	 
		String date = request.getParameter("date");
		LocalDate local = LocalDate.parse(date);

		HttpSession session = request.getSession();
		session.setAttribute("Date", local);
		
		TransactionDaoimpl tranDao = new TransactionDaoimpl();
         List<Transaction> list = tranDao.getbyDate(local);
         
         request.setAttribute("ViewList", list);
		 RequestDispatcher rd=request.getRequestDispatcher("TransactionDateView.jsp");
		 try {
			rd.forward(request, response);
		} catch (ServletException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		 
	}

}
