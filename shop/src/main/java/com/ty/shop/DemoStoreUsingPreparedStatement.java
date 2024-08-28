package com.ty.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoStoreUsingPreparedStatement {
private static String URL="jdbc:postgresql://localhost:5432/shop";
private static String user="postgres";
private static String password="root";
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		
		Connection con=DriverManager.getConnection(URL, user, password);
		String sql="Insert into product values(?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1,5);
		pstm.setString(2,"Iphone 13");
		pstm.setDouble(3, 120000);
		pstm.setInt(4, 3);
		pstm.execute();
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
