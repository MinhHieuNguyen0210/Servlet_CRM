package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DTO.TaskDTO;
import com.java.dao.TaskDao;

@WebServlet(urlPatterns = { "/task", "/task/add", "/task/edit","/task/details" })

public class TaskController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TaskDao taskDao = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/task":
			List<TaskDTO> listTask = new ArrayList<>();
			listTask = taskDao.findAll();
			req.setAttribute("tasks", listTask);
			req.getRequestDispatcher("/WEB-INF/views/task/Task.jsp").forward(req, resp);
			break;
		case "/task/add":
			req.getRequestDispatcher("/WEB-INF/views/task/Task-add.jsp").forward(req, resp);
		case "/task/details":
			req.getRequestDispatcher("/WEB-INF/views/task/Task-details.jsp").forward(req, resp);
			
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
