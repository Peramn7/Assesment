package com.task2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest2 {
	private RequestSpecification requestSpec = RestAssured.given();

	@Test
	public void testCreatePost() {
		String requestBody = "{\n" + 
	"\"userId\": 1,\n" + 
	"\"title\": \"Test Title\",\n" + 
	"\"body\":\"Test Body\"\n"
				+ "}";
		requestSpec.contentType(ContentType.JSON)
		.body(requestBody)
		.post("https://jsonplaceholder.typicode.com/posts")
		.then()
		.assertThat()
		.statusCode(201)
		.body("userId", equalTo(1))
		.body("title", equalTo("Test Title"))
		.body("body", equalTo("Test Body"));
	}

}
