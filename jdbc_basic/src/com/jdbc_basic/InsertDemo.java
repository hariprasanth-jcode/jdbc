package com.jdbc_basic;

import java.sql.Connection;
import java.sql.DriverManager;

public class InsertDemo {
public static void main(String[] args) throws Exception {
	//Load and Register Driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");
	
	System.out.println("Driver class loaded sucess fully");
	con.prepareCall("insert into ")
	
	
}
}
