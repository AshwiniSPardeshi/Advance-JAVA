package com.cdac.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.service.DatabaseLoginService;
import com.cdac.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login4.cdac")
public class LoginServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		LoginService loginService = new DatabaseLoginService();
		boolean isValid = loginService.isValidUser(username, password);
		if(isValid)
			response.sendRedirect("welcome.html");
		else
			response.sendRedirect("loginsimple.html");
	}

}
