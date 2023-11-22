package test;

import org.testng.annotations.DataProvider;

public class DataForTests {
	@DataProvider(name = "DataForPostRequest")
	public Object[][] dataForPost(){
		
//		Object [][] data = new Object[2][2];
//		
//		data[0][0] = "Mrunali";
//		data[0][1] = "Doctor";
//		
//		data[1][0] = "Mayuri";
//		data[1][1] = "Teacher";
//		
//		return data;
		return new Object[][] {
			{"Tau","Lawyer"},
			{"Mau","Judge"},
			{"Chiu","Police"}
		};
	}

}
