package sdet.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {

	Connection conn=null;
	ResultSet result=null;
	public void connectToDatabase() throws SQLException
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(Ipathconstants.DBurl, Ipathconstants.DBusername, Ipathconstants.DBpassword);
		
	}
	
	public void closeDB() throws SQLException
	{
		conn.close();
	}
	
	public String executeQueryandGetdata(String query,int columnindex,String expData) throws SQLException
	{
		boolean flag=false;
		result=conn.createStatement().executeQuery(query);
		while(result.next())
		{
			String data = result.getString(columnindex);
			if(data.equalsIgnoreCase(expData))
			{
				
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData +"the data is verified");
			return expData;
		}
		else
		{
			System.out.println(expData +"the data is not verified");
			return expData;
		}
		
			
	}
}
