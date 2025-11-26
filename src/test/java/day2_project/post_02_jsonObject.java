package day2_project;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class post_02_jsonObject {

		
		@Test
		void testPostMethodUsingJsonObject()
		{
			JSONObject data = new JSONObject();
			data.put("name","RajaKishore");
			data.put("location", "United Kingdom");
			data.put("phone","07500512345");
			String coursesArr[] = {"Python","Java"};
			data.put("courses",coursesArr);
			
			given()
				.contentType("application/json")
				.body(data.toString())
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
