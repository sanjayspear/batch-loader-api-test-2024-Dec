package tests;

// TestNG imports for assertions and test annotations
import org.testng.Assert;
import org.testng.annotations.Test;

// Static imports for RestAssured methods to enhance code readability
import static io.restassured.RestAssured.*;

// Hamcrest Matcher import for validating response body content
import static org.hamcrest.Matchers.*;

// RestAssured response handling import
import io.restassured.response.Response;

public class TestExamples3 {

    /**
     * Test to validate the response code and verify key details from the GET API call.
     */
    @Test
    public void test_1() {
        // Send a GET request to the specified endpoint
        Response response = get("https://reqres.in/api/users?page=2");
        
        // Extract HTTP status code from the response
        int actualStatusCode = response.getStatusCode();
        
        // Extract response time in milliseconds
        long time = response.getTime();

        // Print key response details for debugging
        System.out.println("Response Code: " + actualStatusCode + " and the response time: " + time);
        System.out.println("Response Body: " + response.getBody().asPrettyString());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Header Content Type: " + response.getHeader("content-type"));
        
        // Assert that the actual status code matches the expected status code (200)
        Assert.assertEquals(actualStatusCode, 200);
    }
    
    /**
     * Test to validate the response status code and specific email in the response body.
     */
    @Test
    public void test_2() {
        // Set the base URI for the API
        baseURI = "https://reqres.in/api";
        
        // Use RestAssured's BDD-style syntax for request and response validation
        given()
            .get("/users?page=2")
            .then()
            .statusCode(200) // Assert the status code
            .body("data[1].email", equalTo("lindsay.ferguson@reqres.in")) // Validate email in the response body
            .log().all(); // Log the response for debugging
    }
}
