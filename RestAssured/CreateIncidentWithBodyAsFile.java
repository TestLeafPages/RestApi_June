package Incident;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFile {

	@DataProvider(name = "createIncident")
	public String[][] fetchData() {
		String[][] filePath = new String[2][2];
		// 1 st record
		filePath[0][0] = "application/json";
		filePath[0][1] = "./data/CreateIncident1.json";
		// 2 nd record
		filePath[1][0] = "application/xml";
		filePath[1][1] = "./data/CreateIncident1.xml";
		return filePath;
	}	
	
	@Test(dataProvider = "createIncident")
	public void createIncidentWithBody(String type,String filePath) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		
		File file = new File(filePath);
		
		Response response = RestAssured
				.given()
				.contentType(type)
				.body(file)
				.post();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
