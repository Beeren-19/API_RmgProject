package sdet.PathparametersandAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerToken {

	@Test
	public void bearertoken()
	{
		HashMap map=new HashMap();
		map.put("name", "BEERENDRA");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then()
		.log().all();
		
	}
}
