package sdet.PathparametersandAuthentication;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Outh2authentication {

	@Test
	public void outh2authentication()
	{
		Response resp = given()
		.formParam("client_id", "Myapplication")
		.formParam("client_secret", "2c75b921f2c10b0c5abc56d2af826e7c")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp.asString());
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth()
		.oauth2(token)
		.pathParam("User_Id", "2304")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{User_Id}/chickens-feed")
		.then()
		.log().all();
	}
}
