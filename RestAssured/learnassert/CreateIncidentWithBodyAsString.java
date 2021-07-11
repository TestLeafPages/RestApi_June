package learnassert;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsString {

	@Test
	public void createIncidentWithoutBody() {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\": \"create incident with body json\",\"category\": \"hardware\"}")
				.post()
				.then()
//				.body("result.short_description", Matchers.equalTo("create incident with body"))
				.body("result.short_description", Matchers.containsString("create incident with body"))
				.extract().response();
		
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
