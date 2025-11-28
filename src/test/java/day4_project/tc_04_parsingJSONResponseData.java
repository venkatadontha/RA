package day4_project;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class tc_04_parsingJSONResponseData extends JsonServerApiTest{

	@Test
	void testJSONResponse() {

	    Response res =
	            given()
	                    .contentType(ContentType.JSON)
	            .when()
	                    .get("http://localhost:3000/book");

	    JSONArray ja = new JSONArray(res.asString());

	    boolean found = false;

	    for (int i = 0; i < ja.length(); i++) 
	    {
	        String title = ja.getJSONObject(i)
	                         .getString("title");

	        if (title.equals("Lessons Learned in Software Testing")) {
	            found = true;
	            break;
	        }
	    }

	    Assert.assertTrue(found, "Expected book title not found in response");
	    System.out.println("Expected book is found in the JSON");
	}
}