package com.qa.owner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class OwnerTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Before

	public void page200(){

		request = given().contentType(ContentType.JSON);

		response = request.when().get("http://10.0.10.10:9966/petclinic/swagger-ui.html#/");

		System.out.println("response: " + response.prettyPrint());

	}
	
	@Ignore
	@Test
	public void postOwner() {


		JSONObject object = new JSONObject();
		 
		//start building the request parameters

		object.put("address", "66 Oak Lane");
		object.put("city", "This is a test");
		object.put("firstname", "ANTHIA");
		object.put("id", "7");
		object.put("lastname", "ANTHIA");

		System.out.println(request.body(object.toString()));
		 
		Response response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
		// finally send the request we have built u

		System.out.println(response.getStatusCode());

		}
	
	@Ignore
	@Test
	public void updateOwner() {


		JSONObject object = new JSONObject();
		
		object.put("address", "67 Oak Lane");
		object.put("city", "Manchester");
		object.put("firstname", "Anmar");
		object.put("id", "7");
		object.put("lastname", "Smith");

		System.out.println(request.body(object.toString()));
		 
		Response response = request.post("");


		System.out.println(response.getStatusCode());

		}
	
	@Test
	public void deleteOwner() {


		JSONObject object = new JSONObject();	 
		System.out.println(request.body(object.toString()));		 
		Response response = request.delete("http://10.0.10.10:9966/petclinic/api/owners/7");
		System.out.println(response.getStatusCode());
		System.out.println();

		}

}
