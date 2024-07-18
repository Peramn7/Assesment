package com.task2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest1 {
	private RequestSpecification requestSpec=RestAssured.given();
	@Test
	public void testGetPostById(){
		requestSpec.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
		.assertThat()
		.statusCode(200)
		.body("userId",equalTo(1))
		.body("id", equalTo(1))
		.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
		
		
		
	}
}
