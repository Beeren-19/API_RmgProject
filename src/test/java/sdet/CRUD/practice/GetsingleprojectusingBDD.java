package sdet.CRUD.practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetsingleprojectusingBDD {

	@Test
	public void getsingleprojectusingBDD()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
		.get("/projects/TY_PROJ_1005")
		
		.then()
		.assertThat().statusCode(200).log().all();
		
	}
}
