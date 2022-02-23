package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/car-rental", "root", "");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		if(connection == null) System.out.println("error");
		else System.out.println("done");
	}
}
