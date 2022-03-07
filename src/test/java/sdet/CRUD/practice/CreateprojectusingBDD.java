package sdet.CRUD.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateprojectusingBDD {

	@Test
	public void createprojectusingBDD()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Gkbeeren");
		jobj.put("projectName", "BDD");
		jobj.put("status", "Ongoing");
		jobj.put("teamSize", 40);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201).log().all();
		
		
		
	}
}
