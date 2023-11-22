package test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class Local_APi_Test_Json_server {
	
	@Test
	public void test_01(){
		
		baseURI = "http://localhost:3000";
		given().get("/users").then().log().all();
		
	}
	
	@Test
	public void test_02_post(){
		
		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject();
		request.put("name", "Prashant");
		request.put("lastname", "Mahajan");
		request.put("job", "Engineer");
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().
		post("/users").then().log().all();
		
		
	}


}
