package com.fuel.Util.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CusDBConnection {

	private volatile static Connection connection;

	private CusDBConnection() {
	}

	public static Connection getDBConnection(){
		if (connection == null) {
			synchronized (CusDBConnection.class) {
				if (connection == null) {
					try {
						Class.forName("com.mysql.jdbc.Driver");

						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_managment", "root", "root");

						// creating table
						Statement statment = connection.createStatement();
						statment.execute(CommonConstant.createEmpTable);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
		return connection;
	}
}
