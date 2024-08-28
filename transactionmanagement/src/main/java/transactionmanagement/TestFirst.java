package transactionmanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TestFirst {
public static void main(String[] args) {
	Connection connection=ConnectionPool.getConnectionObject();
	String sqlBook_info="INSERT INTO booking_info VALUES(1,'AIR-IND-101','BLR','US')";
	
	String sqlPass_info1="insert into passenger_info values(1,'Allen',23,'Male')";
	String sqlPass_info2="insert into passenger_info values(2,'Miller',24,'Male')";
	String sqlPass_info3="insert into passenger_info values(3,'Sheela',25,'Female')";
	
	String sqlPay_info="insert into payment_info values(1,1,250000,7000,'requested')";
	
	try {
		connection.setAutoCommit(false);
		Statement stm1 = connection.createStatement();
		stm1.execute(sqlBook_info);
		Savepoint savepoint = connection.setSavepoint();
		Statement stm2 = connection.createStatement();
		stm2.execute(sqlPass_info1);
		Statement stm3 = connection.createStatement();
		stm3.execute(sqlPass_info2);
		Statement stm4 = connection.createStatement();
		stm4.execute(sqlPass_info3);
		if(DemoPaymentGateWay.isSucess()) {
		Statement stm5 = connection.createStatement();
		stm5.execute(sqlPay_info);
		connection.commit();
		System.out.println("Transaction sucess");
		}else {
			connection.rollback(savepoint);
			connection.commit();
			System.out.println("Transaction failed");
		}
		
		ConnectionPool.recieveConnectionObject(connection);
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
