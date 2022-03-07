package sdet.CRUD.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Deleteproject {

	@Test
	public void deleteproject()
	{
		Response res = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1002");
		
		System.out.println(res.prettyPeek());
		System.out.println(res.statusCode());
	}
}
