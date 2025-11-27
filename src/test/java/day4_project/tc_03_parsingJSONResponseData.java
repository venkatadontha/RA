package day4_project;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class tc_03_parsingJSONResponseData {
	
	@Test
	void testJSONResponse()
	{
		Response res = 
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/book");
		  // Convert response body to JSON Array because the root is an array
        JSONArray books = new JSONArray(res.asString());
        
        int totalBooks = books.length();
        System.out.println("The total number of books available in the JSON are: " + totalBooks);

        // Loop through all items and print title
        for (int i = 0; i < books.length(); i++) {
            JSONObject book = books.getJSONObject(i);
            String title = book.getString("title");
            
            
            String author = book.getString("author");
            String category = book.getString("category");
            String price = book.getString("price");
            
            System.out.println("Book title: " + title);
            System.out.println("Book author: " + author);
            System.out.println("Book category: " + category);
            System.out.println("Book price: " + price);
            System.out.println("---------------------------------------------------");

           // System.out.println(title + " | " + author + " | " + category + " | " + price);
            
            
        }
	}
}