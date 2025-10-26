package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDataBaseConnection {

	public static Connection postgres() {
		Connection con=null;
		try {
			//step 1: Load the Driver class
			Class.forName("org.postgresql.Driver");
			//step 2: Establish connection /Open connection
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college?user=postgres&&password=root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static Connection mysql() {
		Connection con=null;
		try {
			//step 1: Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step 2: Establish connection /Open connection
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:3306/college?user=root&&password=Mysql@150599");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
