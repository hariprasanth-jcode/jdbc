package transactionmanagements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
static List<Connection> connection_pool=new ArrayList<Connection>();
static String driver_path="org.postgresql.Driver";
static String url="jdbc:postgresql://localhost:5432/ticket";
static String user="postgres";
static String pwd="root";
static int PoolSize=5;

static {
	try {
		Class.forName(driver_path);
		//Connection con=DriverManager.getConnection(url, user, driver_path);
		
		for(int i=0;i<PoolSize;i++) {
			connection_pool.add(createConnection());
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}

public static Connection createConnection() {
	Connection con=null;
	try {
		con=DriverManager.getConnection(url, user,pwd);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}

public static Connection getConnection() {
	if(!connection_pool.isEmpty()) {
		return connection_pool.remove(0);
	}else {
		return createConnection();
	}
}

public static void reciveConnectionObject(Connection con) {
	if(connection_pool.size()<PoolSize) {
		connection_pool.add(con);
	}else {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
