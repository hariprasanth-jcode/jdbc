package shops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DemoSaveProduct {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/shop";
	String user="postgres";
	String password="root";
	try {
		//Step 1
		Class.forName("org.postgresql.Driver");
		//Step 2
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println(con);
		
		String sql="insert into product values(2,'iphone',70000,4)";
		//Step 3
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}