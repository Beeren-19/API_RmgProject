package sdet.MultipleRequestResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import sdet.GenericUtils.Endpoints;

import static io.restassured.RestAssured.*;

public class ValidateStaticResponse {

	@Test
	public void validatestaticresponse()
	{
		baseURI="http://localhost";
		port=8084;
		//expected data
		String expData="TY_PROJ_005";
		
		//get all the projects
		Response res = when()
		.get(Endpoints.getallprojects);
		
		//get the 0th index of projectid
		String actual = res.jsonPath().get("[2].projectId");
		System.out.println(actual);
		//validate
		Assert.assertEquals(actual, expData);
//		res.then().statusCode(200).log().all();
		
	}
}
