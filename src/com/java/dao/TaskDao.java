package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.DTO.TaskDTO;
import com.java.connection.JDBCConnection;
import com.java.model.Task;

public class TaskDao {
	public List<TaskDTO> findAll() {
		List<TaskDTO> listTask = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "SELECT t.id, t.name as taskname,j.name as jobname,u.fullname, t.start_date, t.end_date,s.name\r\n"
					+ "FROM \r\n"
					+ "((tasks t join users u on t.user_id = u.id) join jobs j on t.job_id = j.id) join status s on s.id = t.status_id\r\n"
					+ "";

			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				TaskDTO task = new TaskDTO();
				task.setId(resultSet.getInt("id"));
				task.setName(resultSet.getString("taskname"));
				task.setJobName(resultSet.getString("jobname"));
				task.setUserName(resultSet.getString("fullname"));
				task.setStart_date(resultSet.getDate("start_date"));
				task.setEnd_date(resultSet.getDate("end_date"));
				task.setStatusName(resultSet.getString("name"));

				listTask.add(task);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listTask;
	}

	// find by id cua user lay tu session
	public List<TaskDTO> findById(int id) {
		List<TaskDTO> listTask = new ArrayList<>();
		try {
			Connection conn = JDBCConnection.getConnection();
			String query = "SELECT t.id, t.name as taskname,j.name as jobname,u.fullname, t.start_date, t.end_date,s.name\r\n"
					+ "FROM ((tasks t join users u on t.user_id = u.id) join jobs j on t.job_id = j.id) join status s on s.id = t.status_id\r\n"
					+ "where user_id = ?;";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				TaskDTO task = new TaskDTO();
				task.setId(resultSet.getInt("id"));
				task.setName(resultSet.getString("taskname"));
				task.setJobName(resultSet.getString("jobname"));
				task.setUserName(resultSet.getString("fullname"));
				task.setStart_date(resultSet.getDate("start_date"));
				task.setEnd_date(resultSet.getDate("end_date"));
				task.setStatusName(resultSet.getString("name"));

				listTask.add(task);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTask;
	}
}
