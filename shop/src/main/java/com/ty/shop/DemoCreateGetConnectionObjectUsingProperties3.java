package com.ty.shop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DemoCreateGetConnectionObjectUsingProperties3 {
public static void main(String[] args) {
	try {
		FileInputStream fis = new FileInputStream("shop_db.properties");

		Properties properties = new Properties();
		System.out.println(properties);
		String driverName= properties.getProperty("driver_name");
	System.out.println(driverName);
		Class.forName(driverName);
	String url=properties.getProperty("URL");
	Connection con = DriverManager.getConnection(url, properties);
	System.out.println(con);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
