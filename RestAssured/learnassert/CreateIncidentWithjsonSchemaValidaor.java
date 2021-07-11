package learnassert;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;


public class CreateIncidentWithjsonSchemaValidaor {

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
				.post()
				.then()
				.assertThat()
				.contentType(ContentType.JSON)
				.statusCode(201)
				//import static io.restassured.module.jsv.JsonSchemaValidator.*;
				.body(matchesJsonSchema(new File("./data/IncidentSchema.json")))
				.extract()
				.response()
				;
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
