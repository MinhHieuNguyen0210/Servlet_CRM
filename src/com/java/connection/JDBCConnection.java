package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Muc dich: Lop ket noi DB voi JBDC
 * */

public class JDBCConnection {

	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/servlet_crm";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "0932627004";

	public static Connection getConnection() {

		try {
			Class.forName(DRIVER);
			try {
				return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
