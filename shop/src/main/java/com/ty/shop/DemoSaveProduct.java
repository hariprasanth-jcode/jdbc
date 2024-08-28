package com.ty.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoSaveProduct {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/shop";
	String user="postgres";
	String password="root";
	
	try {
		//Step1
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded");
		//Step2
		Connection con=DriverManager.getConnection(url, user, password);
		System.out.println(con);
		
		String sql="INSERT INTO product VALUES(3,'Hp Laptop',13000,6)";
		//Step3
		Statement stm=con.createStatement();
		//Step4
		stm.execute(sql);
		//step5
		con.close();
		System.out.println("Data inserted");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
