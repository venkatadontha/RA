package day2_project;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class post_03_POJOClass {
	
	@Test
	void testPostMethodUsingPOJOClass()
	{
		pojo_POSTRequest data = new pojo_POSTRequest();
		
		data.setName("Rajaa");
		data.setLocation("Hyderabad");
		data.setPhone("07500512345");
		String coursesArr[] = {"Azure","AWS"};
		data.setCourses(coursesArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("Rajaa"))
			.body("location",equalTo("Hyderabad"))
			.body("phone",equalTo("07500512345"))
			.body("courses[0]",equalTo("Azure"))
			.body("courses[1]",equalTo("AWS"))
			.header("Content-Type","application/json")
			.log().all();
	}

}
