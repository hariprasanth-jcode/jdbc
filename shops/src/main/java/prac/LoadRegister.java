package prac;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class LoadRegister {
public static void main(String[] args) throws SQLException {
Driver driver=new Driver();
DriverManager.registerDriver(driver);
System.out.println("Driver Loaded");
}
}
