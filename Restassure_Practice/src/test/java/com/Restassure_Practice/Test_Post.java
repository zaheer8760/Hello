package com.Restassure_Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Test_Post {
    
//	@Test
	public void Test01_Post() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "zaheer");
		request.put("job", "software tester");
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201);
}
	
//	@Test
	public void Test02_Put() {
		
		JSONObject request = new JSONObject();
		request.put("name", "zaheer");
		request.put("job", "software tester");
		
		given().
		   header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().
		   put("https://reqres.in/api/users/2").
		then().statusCode(200).log().all();
			
	}
	
	@Test
	public void Test02_Delete() {
		  
		given().
	
		   delete("https://reqres.in/api/users/2").
		then().
		    statusCode(204).log().all();
	}
	
	
}
