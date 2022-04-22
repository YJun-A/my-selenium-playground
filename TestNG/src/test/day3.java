package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	
	
	/*p@Parameters({"URL"}) //this parameter is only applicable to the followed method
	@Test
	ublic void parameterization(String urlname){
		
		System.out.println("Parameter passed from XML file in day3 test case: " + urlname);
		
	}*/
	
	
	@Test(dataProvider="getData")
	public void callDataProvider(String username , String password){
		
		System.out.println(username);
		System.out.println(password);
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() {
		
		//1. username + password -> good credit history
		//2. username + password -> no credit history
		//3. username + password -> fraud credit history
		
		//3 combinations of scenarios , with 2 values being passed to the method
		Object[][] data = new Object[3][2];
		data[0][0] = "firstUsername";
		data[0][1] = "firstPassword";
		data[1][0] = "secondUsername";
		data[1][1] = "secondPassword";
		data[2][0] = "thirdUsername";
		data[2][1] = "thirdPassword";
		
		return data;
		
	}

}//class
