package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DTO.TaskDTO;
import com.java.DTO.UserDTO;
import com.java.dao.TaskDao;

@WebServlet(urlPatterns = { "/profile", "/profile/edit" })
public class ProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TaskDao taskDao = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/profile":

			HttpSession session = req.getSession();

			UserDTO userDTO = new UserDTO();

			userDTO = (UserDTO) session.getAttribute("user");

			List<TaskDTO> listTask = new ArrayList<>();
			listTask = taskDao.findById(userDTO.getId());
			req.setAttribute("tasks", listTask);
			String userName = listTask.get(0).getUserName();
		
			req.setAttribute("userName", userName);
//Tinh phan tram hoan thanh cong viec
			float c1, c2, c3;
			float count1 = 0, count2 = 0, count3 = 0;
			for (TaskDTO taskDTO : listTask) {
				if (taskDTO.getStatusName().equals("Chưa thực hiện")) {
					count1++;
				}
				if (taskDTO.getStatusName().equals("Đang thực hiện")) {
					count2++;
				}
				if (taskDTO.getStatusName().equals("Đã hoàn thành")) {
					count3++;
				}
			}
			c1 = (count1 / listTask.size()) * 100;
			c2 = (count2 / listTask.size()) * 100;
			c3 = (count3 / listTask.size()) * 100;
			
			req.setAttribute("c1", c1);
			req.setAttribute("c2", c2);
			req.setAttribute("c3", c3);
			req.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp").forward(req, resp);
			break;

		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	public void init() throws ServletException {
		taskDao = new TaskDao();
	}
}
