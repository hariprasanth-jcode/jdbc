package shops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoUpdateQuery {
	static String url="jdbc:postgresql://localhost:5432/school";
	static String un="postgres";
	static String pwd="root";
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection(url, un, pwd);
		String sql="Update student set mail='allen123@gmail.com' where name='Allen'";
		Statement stm = con.createStatement();
		System.out.println(stm.executeUpdate(sql));
		con.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
