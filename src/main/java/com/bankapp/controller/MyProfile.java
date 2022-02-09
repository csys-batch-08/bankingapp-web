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

import com.bankapp.impl.UserDetailsDaoimpl;
import com.bankapp.logger.Logger;
import com.bankapp.model.UserDetails;

@WebServlet("/MyProfile")
public class MyProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			String email = (String) session.getAttribute("user_id");
			UserDetailsDaoimpl userdao = new UserDetailsDaoimpl();
			List<UserDetails> userdetlist = userdao.myProfile(email);
			request.setAttribute("userProfileList", userdetlist);
			RequestDispatcher rd = request.getRequestDispatcher("myProfile.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}

}
