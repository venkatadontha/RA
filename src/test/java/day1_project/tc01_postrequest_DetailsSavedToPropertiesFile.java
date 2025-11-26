package day1_project;

import static io.restassured.RestAssured.given;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class tc01_postrequest_DetailsSavedToPropertiesFile {

	  int id;
	    String name;
	    String job;

	    @Test(priority = 1)
	    void createUsers() {

	        HashMap<String, String> data = new HashMap<>();
	        data.put("name", "dvrk");
	        data.put("job", "tester");

	        Response response =
	                given()
	                    .contentType("application/json")
	                    .body(data)
	                    .header("x-api-key", "reqres-free-v1")
	                .when()
	                    .post("https://reqres.in/api/users");

	        id = response.jsonPath().getInt("id");
	        name = response.jsonPath().getString("name");
	        job = response.jsonPath().getString("job");

	        saveUserDetails(id, name, job);

	        System.out.println("Captured ID: " + id);
	        System.out.println("Captured Name: " + name);
	        System.out.println("Captured Job: " + job);
	    }

	    private void saveUserDetails(int id, String name, String job) {
	        try {
	            Properties props = new Properties();
	            props.setProperty("id", String.valueOf(id));
	            props.setProperty("name", name);
	            props.setProperty("job", job);

	            FileOutputStream out = new FileOutputStream("user-details.properties");
	            props.store(out, "Stored user details");
	            out.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}