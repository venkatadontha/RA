package day2_project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import org.testng.annotations.Test;


public class post_01_hashmap {
	
	@Test
	void testPostMethodUsingHashMap()
	{
		HashMap data = new HashMap();
		data.put("name","RajaKishore");
		data.put("location", "United Kingdom");
		data.put("phone","07500512345");
		String coursesArr[] = {"Python","Java"};
		data.put("courses",coursesArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("RajaKishore"))
			.body("location",equalTo("United Kingdom"))
			.body("phone",equalTo("07500512345"))
			.body("courses[0]",equalTo("Python"))
			.body("courses[1]",equalTo("Java"))
			.header("Content-Type","application/json")
			.log().all();
	}
}
