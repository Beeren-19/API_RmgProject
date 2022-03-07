package sdet.CRUD.practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet.GenericUtils.Endpoints;
import sdet.POJOClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateprojectwithPOJO {

	@Test
	public void createProjectWithPOJO()
	{
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary pLib=new ProjectLibrary("vishnuvardhan", "Dada", "completed", 80);
		
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post(Endpoints.addproject)
		
		.then()
		.assertThat().statusCode(201).log().all();
		
	}
}
