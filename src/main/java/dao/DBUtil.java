package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
static	Connection conn;
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
 static Connection	obtainConnection(){
	String connectionUrl="jdbc:postgresql://localhost:5432/bms3";
	String userName="postgres";
	String password="2011";
	
	if(conn==null) {
	 try {
		conn= DriverManager.getConnection(connectionUrl, userName, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	 return conn;

}
}