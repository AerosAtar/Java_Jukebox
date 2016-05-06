package NBGardens;

import java.sql.*;

public class DBConnector 
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mydb";
	static final String USER = "root";
	static final String PASS = "password";
	
	public static void accessDB() 
	{
		Connection conn = null;
		Statement stmt = null;

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println();
		System.out.println("Connection successful");
		System.out.println();
		} 
		
		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void execute
	
	public static void closeDB()
	{
		Connection conn = null;
		Statement stmt = null;

		try 
		{
			if (stmt != null)
				conn.close();
		}
		
		catch (SQLException se) { }

		try 
		{
			if (conn != null)
				conn.close();
		} 
		
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
		
		System.out.println("Goodbye!");
	}
}
