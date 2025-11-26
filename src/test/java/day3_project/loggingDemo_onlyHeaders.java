package day3_project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class loggingDemo_onlyHeaders {
	
		
		@Test
		void logOnlyHeaders()
		{
		
		given()
		.when()
			.get("https://google.com")
		.then()
			.log().headers();
		}

}
