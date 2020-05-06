package connplantsv2.connplantsv2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	private static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static final String dbURL = "jdbc:mysql://connplantservice:3306/connplantsdb";

	private static final String user = "root"; 
	private static final String pass = "VySU8WBweuVYNx3T";

	private static final String dbURLwithUserPswd = dbURL + "?user=" + user + "&password=" + pass + "&useSSL=false";


	private Statement getDBConnectionStatement() throws SQLException {
		Connection databaseConnection= null;

		databaseConnection = DriverManager.getConnection(dbURLwithUserPswd);

		Statement stmt = databaseConnection.createStatement();
		return stmt;
	}

	public String insertMIIShopOrderData(String site, String shoporder, String item, String qty_to_build, String qty_done, String qty_scrapped, String modified_dt) {
		String returnMsg = "" ;
		try
		{
			Statement stmt = getDBConnectionStatement();
			String sql = "INSERT SHOP_ORDER VALUES ('"+site+"','"+shoporder+"','"+item+"','"+qty_to_build+"','"+qty_done+"','"+qty_scrapped+"','"+modified_dt+"')";
			stmt.execute(sql);
			System.out.println("Closing database connection");
		}
		catch (SQLException err)
		{
			System.err.println("Error connecting to the database");
			returnMsg = "ERROR";
			err.printStackTrace(System.err);
			return returnMsg;
			// System.exit(0);
		}
		returnMsg = "SUCCESS";
		System.out.println("Program finished");
		return returnMsg;


	}


	public String insertMIISFCData(String site, String shoporder, String sfc, String status, String qty, String  qty_done, String qty_scrapped, String modified_dt) {
		String returnMsg = "" ;
		String sql = "";
		try
		{
			Statement stmt = getDBConnectionStatement();
			sql = "INSERT SFC VALUES ('"+site+"', '"+sfc+"', '"+shoporder+"', '"+qty+"', '"+qty_done+"' , '"+qty_scrapped+"', '"+status+"', '"+modified_dt+"')";
			stmt.execute(sql);
			System.out.println("Closing database connection");
		}
		catch (SQLException err)
		{
			System.err.println("Error connecting to the database");
			returnMsg = "ERROR " + sql;
			err.printStackTrace(System.err);
			return returnMsg;
			// System.exit(0);
		}
		returnMsg = "SUCCESS";
		System.out.println("Program finished");
		return returnMsg;
	}


/*

	public String dbConn1(String userName, String Password)
	{
		String returnMsg = "" ;
		System.out.println("Program started");
		returnMsg = returnMsg + "Program started"+ "/n";
		try
		{
			Class.forName(jdbcDriver).newInstance();
			System.out.println("JDBC driver loaded successfully 2!");
			returnMsg = returnMsg + "JDBC driver loaded successfully!"+ "/n";
		}
		catch (Exception err)
		{
			System.err.println("Error loading JDBC driver");
			returnMsg = returnMsg + "Error loading JDBC driver"+ "/n";
			err.printStackTrace(System.err);
			System.exit(0);
		}

		Connection databaseConnection= null;
		try
		{
			//Connect to the database
			databaseConnection = DriverManager.getConnection(dbURL,userName,Password);
			System.out.println("Connected to the database successfully 2!");
			System.out.println("Closing database connection");
			returnMsg = returnMsg + "Error loading JDBC driver"+ "/n" + "Closing database connection";

			//close the database connection
			databaseConnection.close();
		}
		catch (SQLException err)
		{
			System.err.println("Error connecting to the database 1!");
			returnMsg = "ERROR - " + returnMsg + "Error connecting to the database" + "/n";
			err.printStackTrace(System.err);
			return returnMsg;
			// System.exit(0);
		}
		returnMsg = "SUCCESS";
		System.out.println("Program finished");
		return returnMsg;
	}
*/

}
