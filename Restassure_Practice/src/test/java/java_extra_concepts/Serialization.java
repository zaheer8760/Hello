package java_extra_concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Serialization {

	@Test
	public void serilizations() {
      
		Map<String,Object> jsonBody = new HashMap<String,Object>();
		List<String> skills = new ArrayList<String>();
		skills.add("java");
		skills.add("php");
		skills.add("python");
		
		jsonBody.put("firstName","zaheer");
		jsonBody.put("lastName","ahmed");
		jsonBody.put("email","zzz@gmail.com");
		jsonBody.put("skills", skills);
		jsonBody.put("id", 4);
		
		System.out.println(jsonBody);
		
		given().
		   header("Content-Type","application/json").
		      baseUri("http://localhost:3000").
                body(jsonBody).when().post("/employees").then().log().all();		
	}
}
