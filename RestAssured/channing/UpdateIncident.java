package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident extends base{

	@Test(dependsOnMethods = {"channing.CreateIncidentWithoutBody.createIncidentWithoutBody"})
	public void updateIncident() {

		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\": \"create incident with body json\", \"category\": \"hardware\"}")
				.pathParam("sysID", sysID)
				.put("{sysID}");
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
