package day4_project;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class tc_02_parsingJSONResponseData {
	
	@Test
	void testJSONResponse()
	{
		Response res =  given()
			.contentType("ContentType.JSON")
		.when()
			.get("http://localhost:3000/book");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");
		String bookTitle = res.jsonPath().get("[5].title").toString();
		Assert.assertEquals(bookTitle, "Agile Testing: A Practical Guide");
		
	}
}