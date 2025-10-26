package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToConnectDatabase {
	public static void main(String[] args) {

		
		
		try {
			
			
			Connection con=CreateDataBaseConnection.postgres();
			//step 3: create statement
			//Statement stmt =con.createStatement();
			String query="insert into student values(?,?,?)";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 6);
			pstm.setString(2,"Smith");
			pstm.setDouble(3, 72);
			//step 4: execute the query
			pstm.execute();
			
			
//			while(result.next()) {
//				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getDouble(3));
//			}
			//step 5:close connection
			con.close();
			
			System.out.println("Executed");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
