package com.ty.shop;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DemoCreateGetConnectionObjectUsingProperties2 {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		FileInputStream fis = new FileInputStream("shop_db.properties");
		Properties properties=new Properties();
		properties.load(fis);
		String url_recieved = properties.getProperty("URL");
		Connection con=DriverManager.getConnection(url_recieved, properties);
	System.out.println(con);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
