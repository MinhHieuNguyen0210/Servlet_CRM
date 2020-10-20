package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DTO.UserDTO;

@WebFilter(urlPatterns = { "" })
public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		// session.removeAttribute("user");
		// Kiem tra trang Login thi ko can kiem tra session
		if (req.getServletPath().startsWith("/login")) {
			chain.doFilter(request, response);
			return;
		}

		if (req.getSession().getAttribute("user") != null) {

			UserDTO dto = (UserDTO) session.getAttribute("user");
			String action = req.getServletPath();
			// Phan quyen nguoi dung
			// 1. Neu la /role thi phai co roleName = ROLE_ADMIN
			if (action.startsWith("/role") &&!(dto.getId() == 1)) {
				resp.sendRedirect(req.getContextPath() + "/error");
				return;
			}

			// 2. Neu la /user thi phai roleName la ROLE_ADMIN hoac ROLE_LEADER
			if (action.startsWith("/user") && !(dto.getId() == 2)) {
				resp.sendRedirect(req.getContextPath() + "/error");
				return;
			}
			// 3. Neu la /home thi phai co roleName thi ROLE_ADMIN hoac ROLE_USER hoac
			// ROLE_LEADER deu vao duoc
			if (action.startsWith("/home")) {
				chain.doFilter(request, response);
				return;
			}
			chain.doFilter(request, response);
		} else {

			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}
