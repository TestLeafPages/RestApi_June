package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident extends base{

	@Test(dependsOnMethods = {"channing.UpdateIncident.updateIncident"})
	public void deleteIncident() {

//		step3: request type (delete) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.pathParam("sysID", sysID)
				.delete("{sysID}");
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
