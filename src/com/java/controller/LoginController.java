package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DTO.UserDTO;
import com.java.dao.UserDao;
import com.java.service.UserService;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginController extends HttpServlet {
	UserDao userDao = null;
	UserService userService = null;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		HttpSession session = req.getSession();
		switch (action) {
		case "/login":
			req.getRequestDispatcher("/WEB-INF/views/login/login1.jsp").forward(req, resp);
			break;
		case "/logout":
			session.removeAttribute("user");
			resp.sendRedirect(req.getContextPath()+"/login");
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String message = "Dang nhap that bai";
		
		UserDTO dto = userService.checkAuth(email, password);

		// Kiem tra dang nhap
		if (dto!=null) {
			resp.sendRedirect(req.getContextPath() + "/home");
			HttpSession session = req.getSession();
			session.setAttribute("user", dto);
			session.setMaxInactiveInterval(1800);
		} else {

			req.setAttribute("message", message);
			req.getRequestDispatcher("/WEB-INF/views/login/login1.jsp").forward(req, resp);
		}
	}

	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
		userService = new UserService();
	}
}
