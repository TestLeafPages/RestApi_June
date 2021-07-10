package Incident;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetIncidentWithXMLParse {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
//		step3: request type (get)
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "sys_id")
//				.accept("application/xml")
				.accept(ContentType.XML)
				.get();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		// response body parse
		XmlPath jsonPath = response.xmlPath();
		
		// get incident number  {get or getList-> arrayValue}
		List<String> list = jsonPath.getList("response.result.sys_id"); 
		
		System.out.println(list.size());
		
		System.out.println(list.get(list.size()-1));
				
		
		for (String eachNumber : list) {
			System.out.println(eachNumber);
		}
		
		
		
		


	}

}
