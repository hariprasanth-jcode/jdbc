package shops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class ToPerformBatchExecution {
	static String url="jdbc:postgresql://localhost:5432/school";
	static String un="postgres";
	static String pwd="root";
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(url, un, pwd);
		String sql="Insert into student values(?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1,201);
		pstm.setString(2,"Smith");
		pstm.setString(3,"Smith123@mail.com");
		pstm.setString(4,"male");
		pstm.addBatch();
		pstm.setInt(1,202);
		pstm.setString(2,"Adam");
		pstm.setString(3,"Adam123@mail.com");
		pstm.setString(4,"male");
		pstm.addBatch();
		pstm.setInt(1,203);
		pstm.setString(2,"Sheela");
		pstm.setString(3,"Sheela123@mail.com");
		pstm.setString(4,"female");
		pstm.addBatch();
		pstm.setInt(1,204);
		pstm.setString(2,"Leela");
		pstm.setString(3,"Leela123@mail.com");
		pstm.setString(4,"female");
		pstm.addBatch();
		int[] count = pstm.executeBatch();
		System.out.println(Arrays.toString(count));
		con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
