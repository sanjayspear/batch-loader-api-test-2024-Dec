package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
//Instead of directly importing RestAssured, the static import is used to allow calling 
//RestAssured methods (e.g., get) without prefixing them with RestAssured.

//Static import
import static io.restassured.RestAssured.*;

//Non-static import
import io.restassured.response.Response;

public class TestExamples2 {

	@Test
	public void test_1() {

		// Before using the static import
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		// After using the static import
		Response response = get("https://reqres.in/api/users?page=2");
		
		int actualStatusCode = response.getStatusCode();
		
		long time = response.getTime();

		System.out.println("Response Code: " + actualStatusCode + " and the response time: " + time);

		System.out.println("Response Body: " + response.getBody().asPrettyString());

		System.out.println("Status Line: " + response.getStatusLine());

		System.out.println("Header Content Type: " + response.getHeader("content-type"));
		
		Assert.assertEquals(actualStatusCode, 200);
		
		/*
		 * Static import allows members (fields and methods) defined in a class to be used directly 
		 * in another class without qualifying them with the class name. This feature was introduced 
		 * in Java 5 to improve code readability and reduce verbosity.
		 * */
	}
	
	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";
		
		given()
		.get("/users?page=2")
		.then().statusCode(200)
		.body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).log().all();
	}
	
}
