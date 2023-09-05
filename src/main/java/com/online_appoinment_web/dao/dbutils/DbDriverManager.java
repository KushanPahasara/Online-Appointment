package com.online_appoinment_web.dao.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbDriverManager {
	
	public Connection getConnection() throws SQLException, ClassNotFoundException;

}
