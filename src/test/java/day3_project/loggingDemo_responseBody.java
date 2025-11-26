package day3_project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class loggingDemo_responseBody {
	
		@Test
		void logBodyResponse()
		{
		
		given()
		.when()
			.get("https://google.com")
		.then()
			.log().body();
		}
}
