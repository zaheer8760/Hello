package com.Restassure_Practice;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {

//	@Test
	public void test_get() {
		baseURI = "http://localhost:3000/";
		
		given().
		  param("name", "Devops").
		    get("/subjects").
		then().
		    statusCode(200).log().all();
	}
	
	
//	@Test
	public void test_post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "vineesh");
		request.put("lastName", "kumar");
		request.put("subjectId", 1);
		
		
		baseURI="http://localhost:3000/";
		
		given().
		header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("/users").then().statusCode(201).log().all();
		
	}
	
	//@Test
	public void Test_put() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "santhosh");
		request.put("lastName", "kumar");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000/";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).accept(ContentType.JSON).
		  body(request.toJSONString()).
		  when().
		  put("/users/4").
		  then().statusCode(200);
	}
	
	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3000/";
		
		given().when().delete("/users/4").then().statusCode(200);
	}
}
