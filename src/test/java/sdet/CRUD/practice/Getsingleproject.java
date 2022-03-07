package sdet.CRUD.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getsingleproject {

	@Test
	public void getsingleproject()
	{
		Response res = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1004");
		
		System.out.println(res.prettyPeek());
		System.out.println(res.statusCode());
		
	}
}
