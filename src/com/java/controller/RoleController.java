package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DTO.RoleDTO;
import com.java.dao.RoleDao;
import com.java.model.Role;
import com.java.service.RoleService;

@WebServlet(urlPatterns = { "/role", "/role/add", "/role/edit","/role/delete" })
public class RoleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RoleDao roleDao = null;
	private RoleService roleService = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/role":
			List<RoleDTO> listRole = new ArrayList<>();

			listRole = roleService.getAll();

			// System.out.println(listRole.get(0).getId());
			req.setAttribute("roles", listRole);

			req.getRequestDispatcher("/WEB-INF/views/role/role-table.jsp").forward(req, resp);

			break;
		case "/role/add":
			req.getRequestDispatcher("/WEB-INF/views/role/role-add.jsp").forward(req, resp);
			break;

		case "/role/edit":
			int id = Integer.parseInt(req.getParameter("id"));

			Role role_edit = roleDao.findById(id);
			req.setAttribute("role", role_edit);
			req.getRequestDispatcher("/WEB-INF/views/role/role-edit.jsp").forward(req, resp);
			break;
		case "/role/delete":
			int idDel = Integer.parseInt(req.getParameter("id"));
			
			roleService.remove(idDel);
			resp.sendRedirect(req.getContextPath()+"/role");
			break;

		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		

		RoleDTO role = new RoleDTO();

		role.setName(name);
		role.setDescription(desc);
	

		String action = req.getServletPath();

		switch (action) {

		case "/role/add":
			roleService.add(role);

			resp.sendRedirect(req.getContextPath() + "/role");
			break;
		case "/role/edit": {
			int id = Integer.parseInt(req.getParameter("id"));
			role.setId(id);
			roleService.edit(role);

			resp.sendRedirect(req.getContextPath() + "/role");
			break;

		}

		default:
			break;
		}
	}

	@Override
	public void init() throws ServletException {
		roleDao = new RoleDao();
		roleService = new RoleService();

	}
}
