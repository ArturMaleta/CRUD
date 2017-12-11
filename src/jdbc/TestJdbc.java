package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "crud";
		String pass = "crud";
		try {
			System.out.println("trying to connect to database");
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Successful");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
