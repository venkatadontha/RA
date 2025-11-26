package day3_project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class captureCookies {
	
	//https://reqres.in/api/users?page=2&id=5
	
	//The output of this test needs to be failed as the cookies value keeps changing in real time so cant verify with a specific cookie value

		@Test
		void testCookies()
		{
		
		given()
		.when()
			.get("https://google.com")
		.then()
			.cookie("AEC","AaJma5v_3QiF9ujwNoPB0o7U1kVMJ4CYGEOrv8XSCs7xCmeRHUilD80beA")
			.log().all();
		}
		
		

}
