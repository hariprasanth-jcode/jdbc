package shops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToRetriveUsingSelectQuery {
	private static String URL="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String passwsord="root";
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(URL, user, passwsord);
		System.out.println(con);
		Statement stm = con.createStatement();
		String sql="select * from student";
	     ResultSet rs = stm.executeQuery(sql);
	    
	     while(rs.next()) {
	    	 int id=rs.getInt(1);
	    	 String name=rs.getString(2);
	    	 String email=rs.getString(3);
	    	 String gender=rs.getString(4);
	    	 
	    	 System.out.println("ID : "+id);
	    	 System.out.println("Name : "+name);
	    	 System.out.println("Email : "+email);
	    	 System.out.println("Gender : "+gender);
	    	 
	    	 System.out.println("===============================================");
	     }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
