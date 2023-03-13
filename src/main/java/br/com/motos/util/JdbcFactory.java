package br.com.motos.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcFactory {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoweb", "root", "152223");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return conn;	

  }
}