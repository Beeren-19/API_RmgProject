package test.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import sdet.GenericUtils.BaseAPIClass;
import sdet.GenericUtils.Endpoints;
import sdet.POJOClass.ProjectLibrary;

public class CreateprojectAndVerifyDB extends BaseAPIClass {

	@Test
	public void createProjectandVerifyDB() throws SQLException
	{
		//create post request
		ProjectLibrary plib=new ProjectLibrary("Ganesh", "MungaruMale", "completed", 82);
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(plib)
		.when()
		.post(Endpoints.addproject);
		
		//extract project id
		String expData = rlib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		//validate the expData in database
		String query = "select * from project;";
		String actData = dlib.executeQueryandGetdata(query, 1, expData);
		System.out.println(actData);
		
		Assert.assertEquals(actData, expData);
		System.out.println("data verified successful");
		
				
	}
}
