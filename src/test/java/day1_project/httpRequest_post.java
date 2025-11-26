package day1_project;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import org.testng.annotations.Test;


public class httpRequest_post {
	
	@Test(priority = 1)
	void createUsers() {

	    HashMap<String, String> data = new HashMap<String, String>();
	    data.put("name", "dvrk");
	    data.put("job", "tester");

	    given()
	            .contentType("application/json")
	            .body(data)
	            .header("x-api-key","reqres-free-v1")
	        .when()
	            .post("https://reqres.in/api/users")
	    	.then()
	    		.statusCode(201)
	            .body("name", equalTo("dvrk"))
	            .body("job", equalTo("tester"))
	    		.log().all();

	}
	
}
