package com.Restassure_Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenExample {

//	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost(){
		return new Object[][] {
			{"priya","dharshini",1},
			{"abdul","hakeem",2}
		};
		
//		Object[][] data = new Object[2][3];
		
//		data[0][0] = "sachin";
//		data[0][1] = "tendulkar";
//		data[0][2] = 2;
//		
//		data[1][0] = "virat";
//		data[1][1] = "kholi";
//		data[1][2] = 1;
//		
//		return data;
		

	}
	
	
//	@Test(dataProvider = "DataForPost")
	public void test01_post(String firstName,String lastName,int subjectId) {
		
		
		
		JSONObject request = new JSONObject();
		request.put("firstName",firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
		baseURI = "http://localhost:3000/";
		given().
		   header("Content-Type","application/json").
		     contentType(ContentType.JSON).accept(ContentType.JSON).
		       body(request.toJSONString()).
		          when().
		            post("/users").then().statusCode(201).log().all();
	}
	
	
	@DataProvider(name = "dataForDelete")
	public Object[] dataForDelete() {
		return new Object[] {
				6,7
		};
	}
	
	@Test(dataProvider = "dataForDelete")
	public void test_delete(int userId) {
		
		baseURI="http://localhost:3000/";
		
		given().when().delete("/users/"+userId).then().statusCode(200);
		  
	}
}
