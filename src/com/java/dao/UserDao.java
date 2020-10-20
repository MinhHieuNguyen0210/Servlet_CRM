package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.java.DTO.UserDTO;
import com.java.connection.JDBCConnection;
import com.java.model.User;

public class UserDao {

	public List<UserDTO> findAll() {
		List<UserDTO> listUser = new ArrayList<>();

		try {
			Connection connection = JDBCConnection.getConnection();

			String query = "SELECT *\r\n" + "from users u join roles r on u.role_id = r.id";

			// tao 1 cai statement de truy van
			PreparedStatement statement = connection.prepareStatement(query);

			// thuc hien cau truy van va tra ve 1 danh sach ket qua (ResultSet)
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				UserDTO user = new UserDTO();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setFullName(resultSet.getString("fullname"));
				user.setAvatar(resultSet.getString("avatar"));
				user.setRole_id(resultSet.getInt("role_id"));
				user.setRole_name(resultSet.getString("name"));

				listUser.add(user);
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listUser;
	}

	public User findById(int id) {
		try {
			// tao 1 connection den database
			Connection connection = JDBCConnection.getConnection();

			String query = "SELECT * FROM users WHERE id = ?";

			// tao 1 cai statement de truy van
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, id);

			// thuc hien cau truy van va tra ve 1 danh sach ket qua (ResultSet)
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				// parse resultSet to Category model
				User user = new User();
				user.setAvatar(resultSet.getString("avatar"));
				user.setEmail(resultSet.getString("email"));
				user.setFullName(resultSet.getString("fullname"));
				user.setId(resultSet.getInt("id"));
				user.setPassword(resultSet.getString("password"));
				user.setRole_id(resultSet.getInt("role_id"));

				return user;
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new User();
	}

	public void Insert(User user) {
		try {
			Connection connection = JDBCConnection.getConnection();

			String query = "INSERT INTO users VALUES (? , ? , ? , ? , ? , ?)";

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, user.getId());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getFullName());
			statement.setString(5, user.getAvatar());
			statement.setInt(6, user.getRole_id());

			statement.executeUpdate();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Update(User user) {
		try {
			Connection connection = JDBCConnection.getConnection();

			String query = "update users " + "set  email = ?, " + "	 password = ?," + "	 fullname = ?,"
					+ "     avatar = ?," + "     role_id = ? " + "where id = ?";

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullName());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, user.getRole_id());
			statement.setInt(6, user.getId());

			statement.executeUpdate();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Delete(int id) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "delete from users " + "where id = ?;";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			statement.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int checkAuth(String email, String password) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "select * from users where email =?;";

			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, email);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				User user = new User();

				user.setAvatar(resultSet.getString("avatar"));
				user.setEmail(resultSet.getString("email"));
				user.setFullName(resultSet.getString("fullname"));
				user.setId(resultSet.getInt("id"));
				user.setPassword(resultSet.getString("password"));
				user.setRole_id(resultSet.getInt("role_id"));

				if (BCrypt.checkpw(password, user.getPassword())) {
					return 1;
				}

			} else
				return 0;

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public User findByEmail(String email) {
		try {
			Connection conn = JDBCConnection.getConnection();

			String query = "select * from users where email =?;";

			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, email);

			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				User user = new User();

				user.setAvatar(resultSet.getString("avatar"));
				user.setEmail(resultSet.getString("email"));
				user.setFullName(resultSet.getString("fullname"));
				user.setId(resultSet.getInt("id"));
				user.setPassword(resultSet.getString("password"));
				user.setRole_id(resultSet.getInt("role_id"));
				
				return user;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<UserDTO> searchByName(String name){
		List<UserDTO> listUser = new ArrayList<>();

		try {
			Connection connection = JDBCConnection.getConnection();

			String query = "SELECT * from users u join roles r on u.role_id = r.id where fullname like '%"+name+"%'";

			// tao 1 cai statement de truy van
			Statement statement = connection.createStatement();

			// thuc hien cau truy van va tra ve 1 danh sach ket qua (ResultSet)
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				UserDTO user = new UserDTO();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setFullName(resultSet.getString("fullname"));
				user.setAvatar(resultSet.getString("avatar"));
				user.setRole_id(resultSet.getInt("role_id"));
				user.setRole_name(resultSet.getString("name"));

				listUser.add(user);
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listUser;

	}	

}
