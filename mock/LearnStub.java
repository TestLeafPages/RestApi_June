package mock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnStub {
	
	@BeforeMethod
	public void mockCreateIncident() {		
		stubFor(post("/api/now/table/incident")
				.willReturn(aResponse()
				.withStatus(201)
				.withHeader("content-type", "application/json")
				.withBody("{ 'sys_id': 'dghfjh3k456l76kn454hg23jg54k',"
						+ " 'Number': 'INC124455',"
						+ "'category': 'inquiry'"
						+ " 'short_description': 'create incident with body json'}")));
	}
	

	@Test
	public void createIncidentWithoutBody() {
		RestAssured.baseURI = "http://localhost:8081/api/now/table/incident";
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
//				.body("{\"short_description\": \"create incident with body json\",\"category\": \"hardware\"}")
				.when()
				.post()
				.then().assertThat()
				.contentType(ContentType.JSON)
				.extract().response();
		response.prettyPrint();
	}
}
