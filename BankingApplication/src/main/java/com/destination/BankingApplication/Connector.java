package com.destination.BankingApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Connector {
	private static Connection connection;
//Function to have JDBC connection for all the modules
	public static Connection Connector() {
		try {
			ResourceBundle rb = ResourceBundle.getBundle("MySqlCredentials");
			String username = rb.getString("username");
			String pwd = rb.getString("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplicationDB",username,pwd);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
