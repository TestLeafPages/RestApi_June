package learnassert;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncident {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number")
				.get()
				.then()
//				.body("result.number[1]", Matchers.equalTo("INC0000032"))
				.body("result.number", Matchers.hasItem("INC0000032"))
				.extract().response();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
