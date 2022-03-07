package sdet.CRUD.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class UpdateprojectusingBDD {

	@Test
	public void updateprojectusingBDD()
	{
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Gkbeeren");
		jobj.put("projectName", "BDD");
		jobj.put("status", "completed");
		jobj.put("teamSize", 40);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.put("/projects/TY_PROJ_1005")
		
		.then()
		.assertThat().log().all();
	}
	
}
