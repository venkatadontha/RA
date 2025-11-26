package day3_project;



import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getSingleHeader {
	
	@Test
	void getSingleHeaderInfo()
	{
		Response res = given()
				.when()
				.get("https://www.google.com/");
		//get single cookie info
		String header_value = res.getHeader("Content-Type");
		System.out.println("Value of the header Content-Type is " + header_value);
	}
}
