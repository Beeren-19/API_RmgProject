package sdet.CRUD.practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetallprojectsusingBDD {

	@Test
	public void getallprojectsusingBDD()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
		//.get("http://localhost:8084/projects")
		.get("/projects")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().time(Matchers.lessThan(1200L), TimeUnit.MILLISECONDS)
		.log().all();
	}
}
