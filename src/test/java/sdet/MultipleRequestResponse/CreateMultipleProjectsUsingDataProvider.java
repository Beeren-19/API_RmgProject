package sdet.MultipleRequestResponse;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet.GenericUtils.Endpoints;
import sdet.POJOClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectsUsingDataProvider {

	@Test(dataProvider="getdata")
	public void createmultipleprojectsusingDataProvider(String createdBy, String projectName, String status, int teamSize)
	{
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary plib=new ProjectLibrary(createdBy, projectName, status, teamSize);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		.when()
		.post(Endpoints.addproject)
		
		.then()
		.assertThat().statusCode(201).log().all();
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] arr=new Object[5][4];
		
		arr[0][0]="bharath";
		arr[0][1]="Raja";
		arr[0][2]="completed";
		arr[0][3]=30;
		
		arr[1][0]="bharath";
		arr[1][1]="Rani";
		arr[1][2]="completed";
		arr[1][3]=25;
		
		arr[2][0]="bharath";
		arr[2][1]="Ramu";
		arr[2][2]="completed";
		arr[2][3]=40;
		
		arr[3][0]="bharath";
		arr[3][1]="Ranga";
		arr[3][2]="completed";
		arr[3][3]=35;
		
		arr[4][0]="bharath";
		arr[4][1]="Ranju";
		arr[4][2]="completed";
		arr[4][3]=45;
		
		return arr;
	}
}
