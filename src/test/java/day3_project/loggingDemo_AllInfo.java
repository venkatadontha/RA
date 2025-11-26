package day3_project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class loggingDemo_AllInfo {
	
		@Test
		void logAllInfo()
		{
		
		given()
		.when()
			.get("https://google.com")
		.then()
			.log().all();
		}
		

}
