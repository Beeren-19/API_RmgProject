package sdet.CRUD.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	public void createproject()
	{
		//create a body by using JSON Object
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Deepak");
		jobj.put("projectName", "Testyantra");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 10);

		//send request
		RequestSpecification req = RestAssured.given();

		req.contentType(ContentType.JSON);

		req.body(jobj);

		Response res = req.post("http://localhost:8084/addProject");

		System.out.println(res.asString());
		System.out.println(res.prettyPeek());
		System.out.println(res.getContentType());
		System.out.println(res.getTime());
		System.out.println(res.getStatusCode());
	}
}
