package sdet.PathparametersandAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet.GenericUtils.Endpoints;
import sdet.POJOClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class ReqestChaining {

	@Test
	public void requestchaining()
	{
		baseURI="http://localhost";
		port=8084;

		ProjectLibrary plib=new ProjectLibrary("shankarNag", "Autoraja", "completed", 60);
//create project
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(plib)
				.when()
				.post(Endpoints.addproject);
		

		//capture the response
		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);

		//perform get operation on the captured id
		given()
		.pathParam("PID", pid)
		.when()
		.get("/projects/{PID}")
		.then()
		.assertThat().statusCode(200).log().all();




	}
}
