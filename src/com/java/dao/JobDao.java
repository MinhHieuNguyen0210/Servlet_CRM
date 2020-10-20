package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.connection.JDBCConnection;
import com.java.model.Job;
import com.java.model.Role;

public class JobDao {
	public List<Job> findAll() {

		List<Job> listJob = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "SELECT * FROM jobs;\r\n" + "\r\n" + "";

			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Job job = new Job();

				job.setId(resultSet.getInt("id"));
				job.setName(resultSet.getString("name"));
				job.setStart_date(resultSet.getDate("start_date"));
				job.setEnd_date(resultSet.getDate("end_date"));

				listJob.add(job);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listJob;
	}

	public void add(Job job) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "insert into jobs(name,start_date,end_date) values (?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, job.getName());
			statement.setDate(2, job.getStart_date());
			statement.setDate(3, job.getEnd_date());
			
			statement.executeUpdate();
		
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public Job findById(int id) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "SELECT * FROM jobs WHERE id = ?;";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Job job = new Job();
				job.setId(resultSet.getInt("id"));
				job.setName(resultSet.getString("name"));
				job.setStart_date(resultSet.getDate("start_date"));
				job.setEnd_date(resultSet.getDate("end_date"));

				return job;
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Job();
	}
	public void edit(Job job) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "update jobs set name =?, start_date =?,end_date =? where id = ?";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, job.getName());
			statement.setDate(2, job.getStart_date());
			statement.setDate(3, job.getEnd_date());
			statement.setInt(4, job.getId());

			statement.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "Delete from jobs Where id =?";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			statement.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
