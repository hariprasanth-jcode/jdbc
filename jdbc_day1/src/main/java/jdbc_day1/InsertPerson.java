package jdbc_day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;

public class InsertPerson {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// load and register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Establish the Connection with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");

		// create the Statrement
		Statement statement = connection.createStatement();

		// execute the Statement or Query
		statement.execute("insert into person values(1,'Hari Prashanth',24,9876543210)");

		// close the Connection
		connection.close();

		System.out.println("successfully data inserted into DB");

	}
}
