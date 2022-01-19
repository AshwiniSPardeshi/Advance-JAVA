package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisteredCustomersServlet
 */
@WebServlet("/registered-customers.cdac")
public class RegisteredCustomersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		out.println("<html><body>");
		out.println("<table border='1' bgcolor='wheat'>");
		out.println("<tr><th>Customer ID</th><th>Name</th><th>Email Address</th></tr>");

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			stmt = conn.prepareStatement("SELECT id, name, email FROM customer");
			rs = stmt.executeQuery();
			

			while(rs.next()) {
				int id = rs.getInt("id"); //1
				String name = rs.getString("name"); //2
				String email = rs.getString("email"); //3
				
				out.println("<tr>");
				out.println("<td>" + id + "</td>");
				out.println("<td>" + name + "</td>");
				out.println("<td>" + email + "</td>");
				out.println("</tr>");
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
		
		out.println("</table></body></html>");
		
	}

}
