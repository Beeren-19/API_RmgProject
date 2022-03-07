package sdet.CRUD.practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteprojectusingBDD {

	@Test
	public void deleteprojectusingBDD()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
		.delete("/projects/TY_PROJ_1003")
		
		.then()
		.assertThat().statusCode(204).log().all();

	}
}
