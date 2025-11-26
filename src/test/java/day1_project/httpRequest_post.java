package day1_project;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class httpRequest_post {
	
	int id;
	
	@Test(priority = 1)
	void createUsers() {

	    HashMap<String, String> data = new HashMap<>();
	    data.put("name", "kishore");
	    data.put("job", "trainer");

	    id = given()
	            .contentType("application/json")
	            .body(data)
	        .when()
	            .post("https://reqres.in/api/users")
	        .then()
	            .statusCode(201)
	            .body("name", equalTo("kishore"))
	            .body("job", equalTo("trainer"))
	            .extract()
	            .path("id");

	    System.out.println("Created user ID: " + id);
	}
//	
//	
//	@Test(priority=2)
//	void udpateUsers()
//	{
//		HashMap data = new HashMap();
//		data.put("name","raja");
//		data.put("job","QA");
//		
//		
//		given()
//			.contentType("application/json")
//			.body(data)
//		.when()
//			.put("https://reqres.in/api/users/"+id)
//		.then()
//			.statusCode(200)
//			.log().all();
//	}

}
