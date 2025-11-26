package day1_project;

import static io.restassured.RestAssured.given;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;


public class postrequest {

	 int id;

	    @Test(priority = 1)
	    void createUsers() {

	        HashMap<String, String> data = new HashMap<String, String>();
	        data.put("name", "kishore");
	        data.put("job", "trainer");

	        id = given()
	                .contentType("application/json")
	                .body(data)
	                .header("x-api-key","reqres-free-v1")
	            .when()
	                .post("https://reqres.in/api/users")
	                .jsonPath().getInt("id");

	        saveIdToFile(id);

	        System.out.println("Created user ID: " + id);
	    }

	    private void saveIdToFile(int id) {
	        try (FileWriter writer = new FileWriter("user-id.txt")) {
	            writer.write(String.valueOf(id));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}