package sdet.GenericUtils;

import io.restassured.response.Response;

public class RestassuredUtilities {

	/**
	 * This method will return the json data after extracting from json path
	 * @param resp
	 * @param jsonpath
	 * @return
	 */
	public String getJsonData(Response resp,String jsonpath)
	{
		String jsonData = resp.jsonPath().get(jsonpath);
		return jsonData;
	}
}
