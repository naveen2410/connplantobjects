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

	public String insertMIIShopOrderData(String site, String shoporder, String item, String qty_to_build, String qty_done, String qty_scrapped, String modified_dt, String router, String handle) {
		String returnMsg = "" ;
		try
		{
			Statement stmt = getDBConnectionStatement();
			String sql = "INSERT SHOP_ORDER VALUES ('"+site+"','"+shoporder+"','"+item+"','"+qty_to_build+"','"+qty_done+"','"+qty_scrapped+"','"+modified_dt+"','"+router+"','"+handle+"')";
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
			sql = "INSERT SFC VALUES ('"+site+"', '"+sfc+"', '"+shoporder+"', "+qty+", "+qty_done+" , "+qty_scrapped+", '"+status+"', '"+modified_dt+"')";
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

	public String insertMIIOperationData(String site, String shoporder, String sfc, String operation, String router,
			String material, String workcenter, String qty_queue, String qty_work, String qty_complete,
			String step_id) {
		String returnMsg = "" ;
		String sql = "";
		try
		{
			Statement stmt = getDBConnectionStatement();
			sql = "INSERT OPERATION VALUES ('"+site+"', '"+shoporder+"', '"+sfc+"', '"+operation+"', '"+router+"', '"+material+"', '"+workcenter+"', "+qty_queue+", "+qty_work+" , "+qty_complete+", '"+step_id+"')";
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

	public String insertMIISiteData(String site, String description, String time_zone) {
		String returnMsg = "" ;
		String sql = "";
		try
		{
			Statement stmt = getDBConnectionStatement();
			sql = "INSERT SITE_MASTER VALUES ('"+site+"', '"+description+"', '"+time_zone+"')";
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

	public String insertMIIResourceData(String site, String resource, String res_desc, String workcenter,
			String wc_desc) {
		String returnMsg = "" ;
		String sql = "";
		try
		{
			Statement stmt = getDBConnectionStatement();
			sql = "INSERT RESOURCE_MASTER VALUES ('"+site+"', '"+resource+"', '"+res_desc+"', '"+workcenter+"', '"+wc_desc+"')";
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

}
