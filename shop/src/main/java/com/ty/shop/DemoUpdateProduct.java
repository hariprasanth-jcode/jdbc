package com.ty.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoUpdateProduct {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/shop";
	String user="postgres";
	String password="root";
	
	try {
		//Step 1
		Class.forName("org.postgresql.Driver");
		//Step 2
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql="UPDATE product set quantity=10 Where id=2";
		//Step 3
		Statement stm=con.createStatement();
		//Step 4
		stm.execute(sql);
		//Step 5
		con.close();
		System.out.println("Data updated");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
