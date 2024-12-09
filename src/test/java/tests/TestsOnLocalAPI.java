package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

@SuppressWarnings("unchecked")

public class TestsOnLocalAPI {
	
	@Test
	public void get() {
		baseURI = "http://localhost:3000/";
		
		given().get("/users").then().statusCode(200).log().all();
	}
	
	@Test
	public void post() {
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Thomas");
		request.put("lastName", "Edison");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);
	}
	
	@Test
	public void put() {
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Albert");
		request.put("lastName", "Doe");
		request.put("subjectId", 2);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/6489").
		then().
			statusCode(200);
	}
	
	@Test
	public void patch() {
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Bolt");
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/6489").
		then().
			statusCode(200);
	}
	
	@Test
	public void delete() {		
		
		baseURI = "http://localhost:3000/";
			
		when().
			delete("/users/5ca0").
		then().
			statusCode(200);
	}
}
