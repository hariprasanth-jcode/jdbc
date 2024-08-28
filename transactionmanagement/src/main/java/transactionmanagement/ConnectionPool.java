package transactionmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
private static List<Connection> connection_pool=new ArrayList<Connection>();
private static String driverpath="org.postgresql.Driver";
private static String URL="jdbc:postgresql://localhost:5432/ticket";
private static String user="postgres";
private static String password="root";
private static final int POOL_SIZE=5;

static {
	try {
		Class.forName(driverpath);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void recieveConnectionObject(Connection connection) {
	if(connection_pool.size()<POOL_SIZE) {
		connection_pool.add(connection);
	}
}
public static Connection getConnectionObject() {
	if(!connection_pool.isEmpty()) {
		return connection_pool.remove(0);
	}else {
		return createConnection();
	}
}
private static Connection createConnection() {
	Connection con=null;
		try {
			con=DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}

