package shops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoSelectQuery {
	static String url="jdbc:postgresql://localhost:5432/school";
	static String un="postgres";
	static String pwd="root";
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		
		Connection con = DriverManager.getConnection(url,un,pwd);
		
		String sql="select * from student";
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			System.out.println("ID : "+" "+rs.getInt("id"));
		System.out.println("Name : "+" "+rs.getString("name"));
		System.out.println("Mail : "+" "+rs.getString("mail"));
		System.out.println("Gender : "+" "+rs.getString("Gender"));
		System.out.println("--------------------------------------------------------");
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
