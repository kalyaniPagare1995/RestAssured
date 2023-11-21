package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Test_Get {
	
	@Test
	public void test_01_get() {
		
		given()
		.get("https://reqres.in/api/users?page=2")
	.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7)).log().all();
		
	}
	
	@Test
	public void test_02_get() {
		
		given()
		.param("Key", "values")
		.header("key", "value")
		.get("https://reqres.in/api/users?page=2")
	.then()
		.statusCode(200)
		.log().all()
		.body("data.first_name", hasItems("Michael","Lindsay"));
		
		
	}
	
	

}
