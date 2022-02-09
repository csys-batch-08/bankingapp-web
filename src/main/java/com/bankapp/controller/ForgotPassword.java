package com.bankapp.controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.logger.Logger;
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
 	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		try {
		String email=request.getParameter("userId");
		String password=request.getParameter("pwd");
	    UserDetailsDaoimpl userDetailDao=new  UserDetailsDaoimpl();
		userDetailDao.forgotPassword(password, email);
		response.sendRedirect("login.jsp");
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
