	package com.java.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.JobDao;
import com.java.model.Job;

@WebServlet(urlPatterns = { "/jobs", "/jobs/add", "/jobs/details", "/jobs/edit", "/jobs/delete" })
public class JobController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	JobDao jobDao = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/jobs":

			List<Job> listJob = new ArrayList<>();

			listJob = jobDao.findAll();

			req.setAttribute("jobs", listJob);

			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork-table.jsp").forward(req, resp);

			break;
		case "/jobs/add":
			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork-add.jsp").forward(req, resp);

			break;
		case "/jobs/edit":
			Job job = new Job();
			int id = Integer.parseInt(req.getParameter("id"));
			job = jobDao.findById(id);
			req.setAttribute("job", job);
			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork-edit.jsp").forward(req, resp);
		case "/jobs/details":
			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork-details.jsp").forward(req, resp);
			break;
		case "/jobs/delete":
			int idDel = Integer.parseInt(req.getParameter("id"));
			jobDao.delete(idDel);
			resp.sendRedirect(req.getContextPath()+"/jobs");
			
			
			
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		String name = req.getParameter("name");

		Date sqlStart_date = null;
		Date sqlEnd_date = null;


		try {
			java.util.Date utilDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("start_date"));
			sqlStart_date = new Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			java.util.Date utilDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("end_date"));
			sqlEnd_date = new Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Job job = new Job();
		job.setName(name);
		job.setStart_date(sqlStart_date);
		job.setEnd_date(sqlEnd_date);

		switch (action) {
		case "/jobs/add":
			jobDao.add(job);
			resp.sendRedirect(req.getContextPath() + "/jobs");
			break;
		case "/jobs/edit":
			int id = Integer.parseInt(req.getParameter("id"));
			job.setId(id);
			jobDao.edit(job);
			resp.sendRedirect(req.getContextPath()+"/jobs");
	
		default:
			break;
		}
	}

	@Override
	public void init() throws ServletException {
		jobDao = new JobDao();
	}

}
