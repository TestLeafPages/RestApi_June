package mock;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MockRecodingWithCreateIncident {

	@Test
	public void createIncidentWithoutBody() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.post();
		response.prettyPrint();
		System.out.println(response.statusCode());
		
		


	}

}
