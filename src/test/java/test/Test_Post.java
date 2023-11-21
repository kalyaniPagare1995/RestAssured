package test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test_Post {
	
	@Test
	public void test_03_post() {
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		map.put("name", "Kalyani");
//		map.put("job", "Engineer");
//
//		System.out.println(map);
		
		JSONObject request = new JSONObject();

		request.put("name", "Kalyani");
		request.put("job", "Engineer");

		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().
		statusCode(201).log().all();

	}

}
