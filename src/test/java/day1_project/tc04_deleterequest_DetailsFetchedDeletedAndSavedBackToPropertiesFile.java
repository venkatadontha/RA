package day1_project;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class tc04_deleterequest_DetailsFetchedDeletedAndSavedBackToPropertiesFile {
	
	  @Test
	    void deleteUser() {

	        Properties props = loadUserDetails();
	        int userId = Integer.parseInt(props.getProperty("id"));

	        given()
	            .header("x-api-key", "reqres-free-v1")
	        .when()
	            .delete("https://reqres.in/api/users/" + userId)
	        .then()
	            .statusCode(204)   // expected from reqres
	            .log().all();

	        removeStoredDetails();

	        System.out.println("Deleted user ID: " + userId);
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

	    private void removeStoredDetails() {
	        try {
	            Properties props = new Properties();
	            // clearing values after delete
	            props.setProperty("id", "");
	            props.setProperty("name", "");
	            props.setProperty("job", "");

	            FileOutputStream out = new FileOutputStream("user-details.properties");
	            props.store(out, "User deleted, values cleared");
	            out.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


