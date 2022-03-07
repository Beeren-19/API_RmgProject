package sdet.MultipleRequestResponse;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import sdet.GenericUtils.Endpoints;

import static io.restassured.RestAssured.*;

import java.util.List;

import javax.crypto.EncryptedPrivateKeyInfo;

public class ValidateDynamicResponse {

	@Test
	public void validateDynamicResponse()
	{
		baseURI="http://localhost";
		port=8084;
		//expected data
		String expData="BDD";
		
		//get all the projects
		Response res = when()
		.get(Endpoints.getallprojects);
		
		//write json path to get all projectName
		List<String> pname = res.jsonPath().get("projectName");
		for(String actual:pname)
		{
			System.out.println(actual);
			if(actual.equals(expData))
			{
				System.out.println(actual+ " the data is validated");
				break;
			}
		}
		res.then().statusCode(200).log().all();
	}
}
