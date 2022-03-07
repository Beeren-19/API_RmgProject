package sdet.GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class BaseAPIClass {

	public DatabaseUtility dlib=new DatabaseUtility();
	public RestassuredUtilities rlib=new RestassuredUtilities();
	public JavaUtility jlib=new JavaUtility();
	
	@BeforeSuite
	public void bsconfig() throws SQLException
	{
		baseURI="http://localhost";
		port=8084;
		
		dlib.connectToDatabase();
		System.out.println("======DB Connection Successful======");
	}
	
	@AfterSuite
	public void asconfig() throws SQLException
	{
		dlib.closeDB();
		System.out.println("======DB close Successful======");
	}
}
