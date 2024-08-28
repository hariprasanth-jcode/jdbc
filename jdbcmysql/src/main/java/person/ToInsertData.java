package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToInsertData {
	static String url="jdbc:mysql://localhost:3306/persondb";
	static String un="root";
	static String pwd="root";
public static void main(String[] args) throws SQLException {
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, un, pwd);
	String sql="insert into person values(?,?,?,?)";
	 PreparedStatement pstm = con.prepareStatement(sql);
	pstm.setInt(1, 3);
	pstm.setString(2,"Leela");
	pstm.setInt(3,23);
	pstm.setInt(4,234567);
	pstm.execute();
	//System.out.println(con);
	con.close();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
