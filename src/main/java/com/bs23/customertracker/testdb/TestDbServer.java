package com.bs23.customertracker.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServer
 */
@WebServlet("/TestDbServer")
public class TestDbServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
		String user = "tonmoyjdbc";
		String pass = "tonmoy";
		
		String url = "jdbc:mysql://localhost:3306/customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		// get connection to database 
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connection to database: "+ url);
			
			Class.forName(driver);
			
			Connection myConnection = DriverManager.getConnection(url, user, pass);
			
			out.println("Success");
			
			myConnection.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured");
			throw new ServletException(e);
		}
	}

}
