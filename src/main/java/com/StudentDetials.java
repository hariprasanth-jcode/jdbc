package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDetials {

	public static void insertStudent() {
		Connection con = CreateDataBaseConnection.postgres();

		Scanner scan = new Scanner(System.in);

		System.out.println("Fill the Students data");
		try {
			PreparedStatement pstm = con.prepareStatement("insert into student values(?,?,?)");
			System.out.println("Enter Student id");

			pstm.setInt(1, scan.nextInt());

			System.out.println("Enter the Student name");

			pstm.setString(2, scan.next());

			System.out.println("Enter Students percentage");

			pstm.setDouble(3, scan.nextDouble());

			pstm.execute();

			System.out.println("Data Inserted");
			con.close();

		} catch (Exception e) {

		}
	}
	
	public static void fetchAll() {
		Connection con = CreateDataBaseConnection.postgres();
		
		try {
			Statement stm = con.createStatement();
			
			String sql="Select * from student";
			ResultSet result = stm.executeQuery(sql);
			
			while (result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getDouble(3));
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void findById() {
		Connection con = CreateDataBaseConnection.postgres();
		
		try {
			PreparedStatement pst = con.prepareStatement("select * from student where id=?");
			
			System.out.println("Enter the student id");
			Scanner scan=new Scanner(System.in);
			
			int id=scan.nextInt();
			pst.setInt(1, id);
			
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getDouble(3));
			}
			
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
