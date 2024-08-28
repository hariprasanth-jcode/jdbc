package transactionmanagements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestFirst {
public static void main(String[] args) {
	Connection connection=ConnectionPool.getConnection();
	String sqlBook_info="INSERT INTO booking_info VALUES(?,?,?,?)";
	String sqlPass_info="INSERT INTO passenger_info VALUES(?,?,?,?)";
	String sqlPay_info="INSERT INTO payment_info VALUES(?,?,?,?,?)";
	try {
		connection.setAutoCommit(false);
		
		PreparedStatement booking = connection.prepareCall(sqlBook_info);
		booking.setInt(1,1);
		booking.setString(2,"AIR-INDIA-101");
		booking.setString(3,"BLR");
		booking.setString(4, "US");
		
		booking.execute();
        PreparedStatement passenger = connection.prepareCall(sqlPass_info);
	    passenger.setInt(1, 1);
	    passenger.setString(2,"Priya");
	    passenger.setInt(3,22);
	    passenger.setString(4,"Female");
	
		passenger.addBatch();
	
		passenger.setInt(1, 2);
		passenger.setString(2,"Dimple");
		passenger.setInt(3,21);
		passenger.setString(4,"Female");
		
		passenger.addBatch();
		
		passenger.setInt(1, 3);
		passenger.setString(2,"Raju");
		passenger.setInt(3,21);
		passenger.setString(4,"Female");
		
		passenger.addBatch();
		
		passenger.executeBatch();
		
		
		if(DemoPaymentGateway.isSucess()) {
			PreparedStatement payment = connection.prepareCall(sqlPay_info);
		payment.setInt(1, 1);
		payment.setInt(2, 1);
		payment.setInt(3,250000);
		payment.setInt(4, 7000);
		payment.setString(5,"requested");
		payment.execute();
		connection.commit();
		System.out.println("Transaction sucessfull");
		}else {
			connection.rollback();
			System.out.println("Transaction failed , data reverted");
		}
		ConnectionPool.reciveConnectionObject(connection);
		
		System.out.println("Transaction complete");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
