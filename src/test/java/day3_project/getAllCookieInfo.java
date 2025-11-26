package day3_project;



import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getAllCookieInfo {
	
	@Test
	void getSingleCokkieInfo()
	{
		Response res = given()
				.when()
				.get("https://www.google.com/");
		
		//get all cookie info
		
		Map<String,String> cookies_values = res.getCookies();
		
		//This statement will return all the cookies info
		System.out.println(cookies_values.keySet());
		
		//To get all the Cookie values
		for (String k :cookies_values.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k + "        "+ cookie_value);
		}
	}
}
