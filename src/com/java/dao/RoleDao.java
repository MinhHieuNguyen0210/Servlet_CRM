package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.java.connection.JDBCConnection;
import com.java.model.Role;

public class RoleDao {

	public List<Role> findAll() {

		List<Role> listRole = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "select * from roles;";

			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));

				listRole.add(role);

			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRole;
	}

	public Role findById(int id) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "SELECT * FROM roles WHERE id = ?;";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));

				return role;
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Role();
	}

	public void Insert(Role role) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "INSERT INTO roles (name, description)value(? , ?)";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());

			statement.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edit(Role role) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "update roles set name =?, description=? where id = ?";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());

			statement.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "Delete from roles Where id =?";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			statement.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
