package java_extra_concepts;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee1 {
 
	
	public static void main(String[] args) throws JsonProcessingException {
		Employee emp = new Employee();
		
		emp.setFirstName("zaheer");
		emp.setLastName("ahmed");
		emp.setEmail("za@gmail.com");
		emp.setSkills(Arrays.asList("java","c#"));
		emp.setId(5);
		
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getEmail());
		System.out.println(emp.getSkills());
		System.out.println(emp.getId());
		
		ObjectMapper obj = new ObjectMapper();
		
		String writeValueAsString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		System.out.println(writeValueAsString);
	}
}
