package java_extra_concepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {

	@Test
	public void SchemaValidations() throws FileNotFoundException {
      
		File inputJson = new File("src/test/java/resources/input.json");
//		InputStream schema = new FileInputStream("src/test/java/java_extra_concepts/schema.json");
		RestAssured.given()
		.header("Content-Type","application/json")
		.baseUri("http://localhost:3000")
		.body(inputJson)
		.when()
		.post("/employees").then().log().all()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\Zaheer\\git\\Hello\\Restassure_Practice\\src\\test\\java\\resources\\validate.json"));
		
		
	}

}
