package sdet.CRUD.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getallprojects {

	@Test
	public void getallprojects()
	{
		Response res = RestAssured.get("http://localhost:8084/projects");
		
		System.out.println(res.prettyPeek());
		System.out.println(res.getStatusCode());
		
	}
}
