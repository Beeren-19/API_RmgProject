package sdet.PathparametersandAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {

	@Test
	public void queryparameter()
	{
		given()
		.queryParam("page", 2)
		
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log().all();
	}
}
