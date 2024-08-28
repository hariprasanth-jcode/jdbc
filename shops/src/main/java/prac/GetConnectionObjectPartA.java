package prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionObjectPartA {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","root");
	System.out.println(con);
}
}
