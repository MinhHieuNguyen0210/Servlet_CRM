package com.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DTO.UserDTO;
import com.java.dao.UserDao;
import com.java.model.User;
import com.java.service.UserService;
import com.myclass.constants.UrlConstants;

@WebServlet(urlPatterns = { UrlConstants.USER_URL, UrlConstants.USER_ADD_URL, UrlConstants.USER_DETAILS_URL, UrlConstants.USER_EDIT_URL,UrlConstants.USER_DELETE_URL,"/user/search" }, name = "userServlet")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDao userDao = null;
	private UserService userService = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.USER_URL:
			List<UserDTO> listUser = userService.getAll();
			req.setAttribute("User", listUser);
			req.getRequestDispatcher("/WEB-INF/views/user/user-table.jsp").forward(req, resp);

			break;
		case  UrlConstants.USER_ADD_URL:
			
			req.getRequestDispatcher("/WEB-INF/views/user/user-add.jsp").forward(req, resp);
			break;
		case UrlConstants.USER_DETAILS_URL:
			int id = Integer.parseInt(req.getParameter("id"));

			UserDTO user = userService.getById(id);

			req.setAttribute("User", user);

			req.getRequestDispatcher("/WEB-INF/views/user/user-details.jsp").forward(req, resp);
			break;
		case UrlConstants.USER_EDIT_URL:
			int id_edit = Integer.parseInt(req.getParameter("id"));
			UserDTO user_edit = userService.getById(id_edit);
	
			req.setAttribute("User", user_edit);
			req.getRequestDispatcher("/WEB-INF/views/user/user-edit.jsp").forward(req, resp);

			break;
		case UrlConstants.USER_DELETE_URL:
			int id_del = Integer.parseInt(req.getParameter("id"));
			
			userService.removeById(id_del);
			
			resp.sendRedirect(req.getContextPath() + "/user");
			break;
		case "/user/search":
			req.getRequestDispatcher("/WEB-INF/views/user/user-search.jsp").forward(req, resp);
			break;

		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action1 = req.getServletPath();
		
		if(action1.equals("/user/search")) {
			String name = req.getParameter("value");
		
			List<UserDTO> listResult = userDao.searchByName(name);
			
			req.setAttribute("searchResult", listResult);
			req.getRequestDispatcher("/WEB-INF/views/user/user-search.jsp").forward(req, resp);

			
			return;
		}
		int id = Integer.parseInt(req.getParameter("id"));
		String fullName = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String avatar = req.getParameter("avatar");
		int role_id = Integer.parseInt(req.getParameter("role_id"));

		UserDTO user = new UserDTO(id, email, password, fullName, avatar, role_id);

		String action = req.getServletPath();

		switch (action) {
		case "/user/add":
			userService.add(user);
			resp.sendRedirect(req.getContextPath() + "/user");

			break;

		case "/user/edit":
		
			userService.edit(user);
			resp.sendRedirect(req.getContextPath()+"/user");
			
		
		default:
			break;
		}

	}

	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
		userService = new UserService();
		
	}

}
