package Incident;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidentWithQueryParam {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("sysparm_fields", "number,sys_id,category");
		params.put("category", "software");
		
//		step3: request type (get)
		Response response = RestAssured.given()
				/*.queryParam("sysparm_fields", "number,sys_id,category")
				.queryParam("category", "software")*/
				.queryParams(params)
				.get();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
