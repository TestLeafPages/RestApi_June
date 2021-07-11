package learnassert;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidentWithCookies {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.cookie("JSESSIONID","D7AA4EF2D24F10B45E72F9917F9EDC24")
				.queryParam("sysparm_fields", "number")
				.get();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		
		Map<String, String> allCookies = response.getCookies();
		
		for(Entry<String, String> eachCookie  :allCookies.entrySet() ) {
			System.out.println(eachCookie.getKey()+" : "+eachCookie.getValue());
		}
		
		


	}

}
