package shops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoRetriveData {
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
			
			String sql="Select * From product";
			//Step 3
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double cost=rs.getDouble(3);
				int quantity=rs.getInt(4);
				
				System.out.println("ID is : "+id);
				System.out.println("Name : "+name);
				System.out.println("Cost : "+cost);
				System.out.println("Quantity : "+quantity);
				System.out.println("---------------------------------");
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
