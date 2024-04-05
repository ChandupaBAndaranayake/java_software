package Model;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
public class Database {
	


	private static Connection con;

	static {
	try {
	//load the Driver and Registering it
	Class.forName("com.mysql.cj.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/vehicle_rental_system";
	String username = "root";
	String password = "";
	//Connection is a interface , so cannot instantiate a interface
	con = DriverManager.getConnection(url, username, password);
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	//returning the connection
	public static Connection getConnection() {
	return con;
	}
	

}
