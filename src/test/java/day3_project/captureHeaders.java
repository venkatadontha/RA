package day3_project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class captureHeaders {
	

		@Test
		void testCookies()
		{
		
		given()
		.when()
			.get("https://google.com")
		.then()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.header("Content-Encoding","gzip")
			.header("Server","gws")
			.log().all();
		}
		
		

}
