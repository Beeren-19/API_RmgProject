package sdet.PathparametersandAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Pathaparameter {

	@Test
	public void pathparameter()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("projId", "TY_PROJ_005")
		
		.when()
		.get("/projects/{projId}")
		
		.then()
		.assertThat().statusCode(200).log().all();
	}
}
