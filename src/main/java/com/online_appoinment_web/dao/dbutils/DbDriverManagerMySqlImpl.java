package com.online_appoinment_web.dao.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDriverManagerMySqlImpl implements DbDriverManager {

	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://127.0.0.1:3306/online_appoinment";
		String userName = "root";
		String password = "";
		
		return DriverManager.getConnection(url, userName, password);
		
	}

}
