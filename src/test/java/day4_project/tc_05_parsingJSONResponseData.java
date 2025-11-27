package day4_project;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class tc_05_parsingJSONResponseData {

	@Test
	void testJSONResponse() {

	    Response res =
	            given()
	                    .contentType(ContentType.JSON)
	            .when()
	                    .get("http://localhost:3000/book");

	    JSONArray ja = new JSONArray(res.asString());

        double totalPrice = 0;

        for (int i = 0; i < ja.length(); i++) {
            double price = ja.getJSONObject(i).getDouble("price");
            totalPrice += price;
        }

        System.out.println("Total Price of all the books is: " + totalPrice);

        Assert.assertTrue(totalPrice > 0, "Total price should not be zero");
        Assert.assertEquals(totalPrice, 220.0);
    }
}