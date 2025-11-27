package day1_project;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.Test;

public class tc03_patchrequest_DetailsFetchedPatchedAndSavedBackToPropertiesFile {
	
	 @Test
	    void patchUser() {

	        Properties props = loadUserDetails();

	        int userId = Integer.parseInt(props.getProperty("id"));
	        String patchedName = "dvrk patched";
	        String patchedJob = "automation lead";

	        HashMap<String, String> data = new HashMap<>();
	        data.put("name", patchedName);   // only updating part of the payload
	        data.put("job", patchedJob);

	        given()
	            .contentType("application/json")
	            .body(data)
	            .header("x-api-key", "reqres-free-v1")
	        .when()
	            .patch("https://reqres.in/api/users/" + userId)
	        .then()
	            .statusCode(200)
	            .log().all();

	        // optionally write patched values back
	        saveUpdatedDetails(userId, patchedName, patchedJob);

	        System.out.println("Patched user ID: " + userId);
	        System.out.println("Patched Name: " + patchedName);
	        System.out.println("Patched Job: " + patchedJob);
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
	            props.store(out, "Patched user details");
	            out.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


