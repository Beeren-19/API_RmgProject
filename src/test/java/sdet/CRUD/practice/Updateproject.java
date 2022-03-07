package sdet.CRUD.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Updateproject {

	@Test
	public void updateproject()
	{
		JSONObject Jobj=new JSONObject();
		Jobj.put("createdBy", "Deepak");
		Jobj.put("projectName", "Testyantra");
		Jobj.put("status", "Completed");
		Jobj.put("teamSize", 50);
		
		RequestSpecification req = RestAssured.given();
		
		req.contentType(ContentType.JSON);
		req.body(Jobj);
		
		Response res = req.put("http://localhost:8084/projects/TY_PROJ_1004");
		System.out.println(res.prettyPeek());
		System.out.println(res.statusCode());
		System.out.println(res.time());
		
		
		
		
		
	}
}
