package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ToReadDataFromUser {
	public static void main(String[] args) {

		
		Connection con = CreateDataBaseConnection.postgres();
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Fill the Students data");
		try {
			PreparedStatement pstm = con.prepareStatement("insert into student values(?,?,?)");
			System.out.println("Enter Student id");
			
			pstm.setInt(1,scan.nextInt());
			
			System.out.println("Enter the Student name");
			
			pstm.setString(2,scan.next());
			
			System.out.println("Enter Students percentage");
			
			pstm.setDouble(3,scan.nextDouble());
			
			pstm.execute();
			
			System.out.println("Data Inserted");
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
