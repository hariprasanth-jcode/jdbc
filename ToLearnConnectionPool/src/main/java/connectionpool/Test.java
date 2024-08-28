package connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ty.project.ConnectionPool;

public class Test {
public static void main(String[] args) {
	Connection con=ConnectionPool.getConnectionObject();
	String sql="INSERT into student values(601,'Dimple','dim@gamil.com')";
	try {
		Statement stm = con.createStatement();
		stm.execute(sql);
		ConnectionPool.reciveConnectionObject(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
