package sdet.CRUD.practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet.GenericUtils.Endpoints;
import sdet.GenericUtils.Ipathconstants;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Createprojectwithjsonfile {

	@Test
	public void createprojectjsonfile() throws FileNotFoundException
	{
		baseURI="http://localhost";
		port=8084;
		
		FileInputStream file=new FileInputStream(Ipathconstants.JsonFilePath);
		
		given()
		.contentType(ContentType.JSON)
		.body(file)
		
		.when()
		.post(Endpoints.addproject)
		
		.then()
		.assertThat().statusCode(201).log().all();
	}
}
