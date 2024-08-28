package com.ty.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class DemoUsingDriverClass {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/shop";
	String user="postgres";
	String password="root";
	Integer
Driver	driver=new Driver();
try {
	DriverManager.registerDriver(driver);
Connection con = DriverManager.getConnection(url, user, password);
String sql="INSERT INTO product VALUES(4,'Milton Water Bottle',600,5)";
Statement stm = con.createStatement();
stm.execute(sql);
con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(driver);
}
}
