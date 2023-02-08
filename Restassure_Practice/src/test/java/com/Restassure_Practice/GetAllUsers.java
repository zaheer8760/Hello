package com.Restassure_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetAllUsers {

	@Test
	void Test_01() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getBody().asString());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);

	}
	
	@Test
	void Test_02(){
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
		
	}
	
	
	
	
	
}
