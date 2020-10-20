package com.java.service;

import java.util.ArrayList;
import java.util.List;

import com.java.DTO.RoleDTO;
import com.java.dao.RoleDao;
import com.java.model.Role;

public class RoleService {

	RoleDao roleDao = null;

	public RoleService() {
		roleDao = new RoleDao();
	}

	public List<RoleDTO> getAll() {

		List<Role> listRole = new ArrayList<>();
		listRole = roleDao.findAll();
		List<RoleDTO> dtos = new ArrayList<>();

		for (Role role : listRole) {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setId(role.getId());
			roleDTO.setName(role.getName());
			roleDTO.setDescription(role.getDescription());

			dtos.add(roleDTO);
		}
		return dtos;

	}
	public void add(RoleDTO roleDTO) {
		//chuyen du lieu tu DTO cho Entity
		Role role = new Role();
		
		role.setName(roleDTO.getName());
		role.setDescription(roleDTO.getDescription());
		
		roleDao.Insert(role);
		
		
		
	}
	public void edit(RoleDTO roleDTO) {
		Role role = new Role();
		
		role.setId(roleDTO.getId());
		role.setName(roleDTO.getName());
		role.setDescription(roleDTO.getDescription());
		
		roleDao.edit(role);
		
	}
	public void remove(int id) {
		roleDao.delete(id);
	}

}
