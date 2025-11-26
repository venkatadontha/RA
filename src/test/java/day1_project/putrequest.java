package day1_project;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import org.testng.annotations.Test;

public class putrequest {
	
	  int id = readIdFromFile();

	  @Test
	  void updateser()
	  {
	    HashMap<String, String> data = new HashMap<String, String>();
	    data.put("name", "rajakishoredontha");
	    data.put("job", "QAssurance");

	    given()
	        .contentType("application/json")
	        .body(data)
	        .header("x-api-key", "reqres-free-v1")
	    .when()
	        .put("https://reqres.in/api/users/" + id)
	    .then()
	        .statusCode(200)
	        .log().all();

	    System.out.println("Updated user ID: " + id);
	}

	private int readIdFromFile() {
	    try {
	        String value = Files.readString(Path.of("user-id.txt")).trim();
	        return Integer.parseInt(value);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}
	}