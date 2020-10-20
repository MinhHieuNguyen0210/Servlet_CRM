package com.java.DTO;

public class UserDTO {
	private int id;
	private String email;
	private String password;
	private String fullName;
	private String avatar;
	private int role_id;
	private String role_name;

	
	public UserDTO() {}
	
	public UserDTO(int id, String email, String password, String fullName, String avatar, int role_id,
			String role_name) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.avatar = avatar;
		this.role_id = role_id;
		this.role_name = role_name;
	}
	
	public UserDTO(int id, String email, String password, String fullName, String avatar, int role_id) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.avatar = avatar;
		this.role_id = role_id;
	
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
}
