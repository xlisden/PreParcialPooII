package com.unu.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static String url = "jdbc:mysql://localhost:3366/preparcial";
	private static String user = "root";
	private static String password = "123456";
	private static Connection conexion;
	
	public static Connection openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, password);
			System.out.println("open connection!");
		} catch (Exception e) {
			System.out.println("openConnection() " + e.getMessage());
		}
		return conexion;
	}
	
	public static Connection closeConnection() {
		try {
			if(conexion != null & !conexion.isClosed()) {
				conexion.close();
				System.out.println("close connection.");
			}
		} catch (Exception e) {
			System.out.println("closeConnection() " + e.getMessage());
		}
		return conexion;
	}

}
