package com.java.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.java.DTO.UserDTO;
import com.java.dao.UserDao;
import com.java.model.User;

public class UserService {

	private UserDao userDao = null;

	public UserService() {
		userDao = new UserDao();
	}

	public List<UserDTO> getAll() {

		List<UserDTO> dtos = userDao.findAll();

		return dtos;
	}

	public UserDTO getById(int id) {

		User user = userDao.findById(id);

		UserDTO userDTO = new UserDTO();

		userDTO.setFullName(user.getFullName());
		userDTO.setEmail(user.getEmail());
		userDTO.setAvatar(user.getAvatar());
		userDTO.setId(user.getId());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole_id(user.getRole_id());

		return userDTO;

	}

	public void removeById(int id) {
		userDao.Delete(id);
	}

	public void add(UserDTO dto) {
		String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(10));
		// Chuyen du lieu tu DTO qua Entity
		User user = new User();

		user.setFullName(dto.getFullName());
		user.setEmail(dto.getEmail());
		user.setAvatar(dto.getAvatar());
		user.setId(dto.getId());
		user.setPassword(hashed);
		user.setRole_id(dto.getRole_id());

		userDao.Insert(user);
	}

	public void edit(UserDTO dto) {
		
		String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(10));
		User user = new User();

		user.setFullName(dto.getFullName());
		user.setEmail(dto.getEmail());
		user.setAvatar(dto.getAvatar());
		user.setId(dto.getId());
		user.setPassword(hashed);
		user.setRole_id(dto.getRole_id());

		userDao.Update(user);
	}

	public UserDTO checkAuth(String email, String password) {
		UserDao userDao = new UserDao();

		User user = userDao.findByEmail(email);

		UserDTO userDTO = new UserDTO();

		if (user == null) {
			return null;
		}
		boolean checked = BCrypt.checkpw(password, user.getPassword());

		if (!checked) {
			return null;
		} else {

			userDTO.setId(user.getId());
			userDTO.setFullName(user.getFullName());
			userDTO.setEmail(user.getEmail());
			userDTO.setAvatar(user.getAvatar());
			userDTO.setPassword(user.getPassword());
			userDTO.setRole_id(user.getRole_id());
		}
		return userDTO;

	}
}
