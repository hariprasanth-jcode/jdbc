package com.ty.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoRetriveProduct {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/shop";
	String user="postgres";
	String password="root";
	
	try {
		//Step 1
		Class.forName("org.postgresql.Driver");
		//Step 2
		Connection con = DriverManager.getConnection(url, user, password);
	  String sql="select * FROM product";
	  //step 3
	  Statement stm = con.createStatement();
	  ResultSet rs = stm.executeQuery(sql);
	  //ResultSet rs = stm.getResultSet();
	  System.out.println(rs);
	  while(rs.next()) {
		  int id=rs.getInt(1);
		  String name=rs.getString(2);
		  double cost=rs.getDouble(3);
		  int quantity=rs.getInt(4);
		  
		  System.out.println("ID :"+id);
		System.out.println("Name :"+name);
		System.out.println("Cost :"+cost);
		System.out.println("Quantity : "+quantity);
	  }
	  con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
