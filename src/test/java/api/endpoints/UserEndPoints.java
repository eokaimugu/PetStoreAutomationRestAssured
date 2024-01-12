package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform CRUD operations

public class UserEndPoints {
	
		public static Response createUser(User payload)
		{
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.postURL);
			return response;
			
		}
	
		public static Response getUser(String userName)
		{
			Response response=given()
				.pathParam("username", userName)
			.when()
				.get(Routes.getURL);
			return response;
			
		}
		
		public static Response updateUser(String userName, User payload)
		{
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
			.when()
				.post(Routes.postURL);
			return response;
			
		}
		
		
		public static Response deleteUser(String userName)
		{
			Response response=given()
				.pathParam("username", userName)
			.when()
				.get(Routes.deleteURL);
			return response;
			
		}

}
