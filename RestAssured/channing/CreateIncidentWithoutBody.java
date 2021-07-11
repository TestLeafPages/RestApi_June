package channing;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody extends base{

	@Test
	public void createIncidentWithoutBody() {
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(new File("./data/CreateIncident.json"))
				.post();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		
		JsonPath jsonPath = response.jsonPath();
		sysID = jsonPath.get("result.sys_id").toString();
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
