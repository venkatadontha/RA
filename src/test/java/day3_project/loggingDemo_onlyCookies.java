package day3_project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class loggingDemo_onlyCookies {
	
		
		@Test
		void logOnlyCookies()
		{
		
		given()
		.when()
			.get("https://google.com")
		.then()
			.log().cookies();
		}
	
}
