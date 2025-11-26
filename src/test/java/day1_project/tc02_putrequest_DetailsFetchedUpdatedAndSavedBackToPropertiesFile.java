package day1_project;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.Test;

public class tc02_putrequest_DetailsFetchedUpdatedAndSavedBackToPropertiesFile {
	
	 @Test
	    void updateUser() {

	        Properties props = loadUserDetails();

	        int userId = Integer.parseInt(props.getProperty("id"));
	        String newName = "dvrk updated";
	        String newJob = "senior tester";

	        HashMap<String, String> data = new HashMap<>();
	        data.put("name", newName);
	        data.put("job", newJob);

	        given()
	            .contentType("application/json")
	            .body(data)
	            .header("x-api-key", "reqres-free-v1")
	        .when()
	            .put("https://reqres.in/api/users/" + userId)
	        .then()
	            .statusCode(200)
	            .log().all();

	        // save updated values back to the same file
	        saveUpdatedDetails(userId, newName, newJob);

	        System.out.println("Updated user ID: " + userId);
	        System.out.println("Updated Name: " + newName);
	        System.out.println("Updated Job: " + newJob);
	    }

	    private Properties loadUserDetails() {
	        try {
	            Properties props = new Properties();
	            FileInputStream in = new FileInputStream("user-details.properties");
	            props.load(in);
	            in.close();
	            return props;
	        } catch (Exception e) {
	            throw new RuntimeException("Unable to load user-details.properties", e);
	        }
	    }

	    private void saveUpdatedDetails(int id, String name, String job) {
	        try {
	            Properties props = new Properties();
	            props.setProperty("id", String.valueOf(id));
	            props.setProperty("name", name);
	            props.setProperty("job", job);

	            FileOutputStream out = new FileOutputStream("user-details.properties");
	            props.store(out, "Updated user details");
	            out.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}