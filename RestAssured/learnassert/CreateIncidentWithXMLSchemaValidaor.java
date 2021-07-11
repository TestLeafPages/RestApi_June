package learnassert;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

import java.io.File;


public class CreateIncidentWithXMLSchemaValidaor {

	@Test
	public void createIncidentWithoutBody() {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		
		Response response = RestAssured
				.given().accept(ContentType.XML)
				.contentType(ContentType.JSON)
				.post()
				.then()
				.assertThat()
				.contentType(ContentType.XML)
				.statusCode(201)
				.body(RestAssuredMatchers.matchesXsd(new File("./data/IncidentXML.xsd")))
				.extract()
				.response()
				;
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
