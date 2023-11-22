package test;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utils.ExcelUtils;

import static io.restassured.RestAssured.*;

public class Test_Post extends DataForTests {
	
//	@Test
//	@Test
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
	
	
	
//	@Test(dataProvider = "DataForPostRequest")
	public void test_04_post_dataProvider(String name,String job ) {
		
		JSONObject request = new JSONObject();

		request.put("name", name);
		request.put("job", job);

		System.out.println(request);

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
	
	@Test
	public void test_05_post_usingExcel() {
		String excelFilepth = "./data/DataForPost.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelFilepth,sheetName );
		int rowcount = excel.getRowCount();
		
		for(int i =1 ;i<rowcount;i++) {
		Object name = excel.getCellData(i, 0);
		Object job = excel.getCellData(i, 1);
		
		JSONObject request = new JSONObject();

		request.put("name", name);
		request.put("job", job);

		System.out.println(request);

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



}
