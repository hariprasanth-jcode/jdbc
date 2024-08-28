package com.ty.shop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DemoCreateObjectUsingPropertiesFile {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		FileInputStream fis = new FileInputStream("shop_db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop", properties);
	System.out.println(con);
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
}
}
