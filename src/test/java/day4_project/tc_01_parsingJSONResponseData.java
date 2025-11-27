package day4_project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class tc_01_parsingJSONResponseData {
	
	@Test
	void testJSONResponse()
	{
		given()
			.contentType("ContentType.JSON")
		.when()
			.get("http://localhost:3000/book")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			.log().all()
			.body("[5].author",equalTo("Lisa Crispin, Janet Gregory"))
			.body("[5].price",equalTo("40"))
			.body("[5].category",equalTo("Agile QA / Automation"))
            .body("[5].title", equalTo("Agile Testing: A Practical Guide"));
	}
}