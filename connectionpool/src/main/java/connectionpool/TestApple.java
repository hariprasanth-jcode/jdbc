package connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApple {
public static void main(String[] args) {
	Connection con = ConnectionPool.getConnectionObject();
	String sql="Update student set gender='female' where id=601";
	try {
		Statement stm = con.createStatement();
		stm.execute(sql);
		//instead of closing the connection we will return the connection
		ConnectionPool.reciveConnectionObject(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
