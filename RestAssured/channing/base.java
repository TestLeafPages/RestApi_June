package channing;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class base {

	public static String sysID = "";
	
	@BeforeSuite
	public void init() {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}
	
	
}
