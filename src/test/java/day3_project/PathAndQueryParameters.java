package day3_project;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&id=5

	@Test
	void PathQueryParams()
	{
	
	given()
		.pathParam("mypath","users")
		.queryParam("page",2)
		.queryParam("id",5)
		.header("x-api-key", "reqres-free-v1")
	.when()
		.get("https://reqres.in/api/{mypath}")
	.then()
		.statusCode(200)
		.log().all();
	}
}
