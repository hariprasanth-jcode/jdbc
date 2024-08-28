package shops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoStoreUsingPreparedStmt {
	private static String URL="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String passwsord="root";
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(URL, user, passwsord);
		String sql="Insert into student values(?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1,105);
		pstm.setString(2,"Smith");
		pstm.setString(3,"Smith@123");
		pstm.setString(4,"male");
		
		pstm.execute();
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
