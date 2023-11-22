package test;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Test_Delete {
	@Test
	public void test_4_delete() {
		
		
		given().
		delete("https://reqres.in/api/users/2").
		then().
		statusCode(204).log().all();
	}
	
		
	
// Below test can run using testng.xml only to run uncomment annotations
//		@Parameters("userId")
//		@Test
		public void test_4_delete(int userId) {
			
			
			System.out.println("userid is "+ userId);
			given().
			delete("https://reqres.in/api/users/"+userId).
			then().
			statusCode(204).log().all();
		}
		

}
