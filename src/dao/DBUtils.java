package dao;

import java.sql.*;

public class DBUtils {

	public static Connection getConnection() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/atmecs",
				"root", "rajendra#123");
	}
}
