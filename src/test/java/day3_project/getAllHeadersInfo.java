package day3_project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class getAllHeadersInfo {
	
	@Test
	void getallHeaders()
	{
		Response res = given()
				.when()
				.get("https://www.google.com/");
		
		Headers myheaders = res.getHeaders();
		for(Header hd : myheaders)
		{
			System.out.println("The value of the Header is : " + hd.getName() +  "<=====>" + hd.getValue());
		}
		
	}
}
