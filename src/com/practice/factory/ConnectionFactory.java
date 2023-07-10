package com.practice.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con = null;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subharghya", "root", "admin");
		} catch(SQLException se) {
			System.out.println("Problem occured for connection");
		}
	}
	public static Connection getConnection() {
		return con;
	}
}