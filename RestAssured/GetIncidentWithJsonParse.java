package Incident;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIncidentWithJsonParse {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
//		step3: request type (get)
		Response response = RestAssured
				.given()
				.get();
//		step4: print response body
//		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		// response body parse
		JsonPath jsonPath = response.jsonPath();
		
		// get incident number  {get or getList-> arrayValue}
		List<String> list = jsonPath.getList("result.number"); 
		
		System.out.println(list.size());
		
		System.out.println(list.get(list.size()-1));
				
//		for (String eachNumber : list) {
//			System.out.println(eachNumber);
//		}
		
		
		
		


	}

}
