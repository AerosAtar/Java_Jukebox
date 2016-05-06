package NBGardens;

import java.sql.*;

public class NBGardens {

	public static void main(String[] args) 
	{
		DBConnector.accessDB();
		DBConnector.closeDB();
	}
}