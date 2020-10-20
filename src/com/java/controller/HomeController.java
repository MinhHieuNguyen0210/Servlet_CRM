package com.java.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.connection.JDBCConnection;

@WebServlet(urlPatterns = { "/home" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		HttpSession session = req.getSession();
		switch (action) {
		case "/home":

			req.getRequestDispatcher("/WEB-INF/views/home/index.jsp").forward(req, resp);

			break;

		default:
			break;
		}
//		try (Connection conn = JDBCConnection.getConnection()) {
//			if (conn != null) {
//				System.out.println("Connect successfully");
//			} else {
//				System.out.println("Connect failed");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
