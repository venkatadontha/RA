package day2_project;

import static io.restassured.RestAssured.baseURI;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class JsonServerApiTest {

    @BeforeClass
    public void setup() {
        JsonServerManager.startServer();
        baseURI = "http://localhost:3000";
    }

    @AfterClass
    public void teardown() {
        JsonServerManager.stopServer();
    }
}

