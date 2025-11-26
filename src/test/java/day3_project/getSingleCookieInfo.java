package day3_project;



import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getSingleCookieInfo {
	
	@Test
	void getSingleCokkieInfo()
	{
		Response res = given()
				.when()
				.get("https://www.google.com/");
		//get single cookie info
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of the Cookie is =====> " + cookie_value);
	}
}
