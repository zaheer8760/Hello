package com.Restassure_Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_Get {

	@Test
	public void Test_01() {
	
		given().
		   get("https://reqres.in/api/users?page=2").
		then().
		   statusCode(200).
		body("data.first_name",hasItems("Michael"));
		
	}
}
