package studentdbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentDetials {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","root");
	Statement stmt = connection.createStatement();
	String sql="insert into student values(1,'Hari','Mech','hari@gmail.com')";
	stmt.execute(sql);
	connection.close();
	System.out.println("Sucessfully data inserted into data");
	
}
}
