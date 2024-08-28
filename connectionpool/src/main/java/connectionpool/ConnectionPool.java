package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
private static ArrayList<Connection> connection_pool=new ArrayList<Connection>();
private static String driverPath="org.postgresql.Driver";
private static String URL="jdbc:postgresql://localhost:5432/school";
private static String user="postgres";
private static String password="root";

private static final int POOL_SIZE=5;

static {
	try {
		Class.forName(driverPath);
		for(int i=0;i<POOL_SIZE;i++) {
			Connection connection=createConnection();
			connection_pool.add(connection);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static Connection getConnectionObject() {
	if(connection_pool.isEmpty()) {
		return connection_pool.remove(0);
	}else {
		return createConnection();
	}
}

public static void reciveConnectionObject(Connection connection) {
	if(connection_pool.size()<POOL_SIZE) {
		connection_pool.add(connection);
	}else {
		try {
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
private static Connection createConnection() {
	Connection connection=null;
	try {
		connection=DriverManager.getConnection(URL, user, password);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
}
}
