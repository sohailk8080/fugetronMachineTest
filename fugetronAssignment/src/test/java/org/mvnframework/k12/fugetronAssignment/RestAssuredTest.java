package org.mvnframework.k12.fugetronAssignment;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredTest {

	@Test
	public void restAssured() {
		//using dummy API to get response
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		int code = resp.getStatusCode();
		System.out.println("Request code is::" + code);
		
		//to get response time
		System.out.println("Response time is::"+resp.getTime());
		
		//using assert to validate actual and expected output
		Assert.assertEquals(code, 200);
	}
}
