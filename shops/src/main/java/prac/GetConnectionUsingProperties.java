package prac;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class GetConnectionUsingProperties {

	private static String url="jdbc:postgresql://localhost:5432/school";
	//jdbc:postgresql://localhost:5432/school
public static void main(String[] args)  {
	try {
		//Class.forName("org.postgresql.Driver");
		FileInputStream fis = new FileInputStream("school_db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String drivername=properties.getProperty("driverClasspath");
		Class.forName(drivername);
		Connection con = DriverManager.getConnection(url, properties);
		System.out.println(con);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
