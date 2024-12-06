package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestExamples {

	// Test case to verify the API response of a GET request
	@Test
	public void test_1() {

		// Send a GET request to the specified URL and store the response
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		// Extract the HTTP status code from the response
		int actualStatusCode = response.getStatusCode();
		
		// Extract the response time in milliseconds
		long time = response.getTime();

		// Print the status code and response time for debugging purposes
		System.out.println("Response Code: " + actualStatusCode + " and the response time: " + time);

		// Print the response body in a formatted (pretty) string for better readability
		System.out.println("Response Body: " + response.getBody().asPrettyString());

		// Print the HTTP status line (e.g., HTTP/1.1 200 OK) from the response
		System.out.println("Status Line: " + response.getStatusLine());

		// Print the value of the "Content-Type" header from the response
		System.out.println("Header Content Type: " + response.getHeader("content-type"));
		
		// Validate that the actual status code is 200 (success) using TestNG assertion
		Assert.assertEquals(actualStatusCode, 200);
	}
}
