package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
private static Connection con=null;
static {
	try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","Ankit","ankit");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
public static Connection getCon() {
	return con;
}

}
