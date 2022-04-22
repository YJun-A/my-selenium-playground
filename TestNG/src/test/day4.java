package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	
	
	@Parameters({"URL" , "API"}) //this parameter is only applicable to the followed method
	@Test
	public void parameterization(String urlname, String api){
		
		System.out.println("Parameter passed from XML file in day4 test case: " + urlname);
		System.out.println("Parameter passed from XML file in day4 test case: " + api);
		
	}

}//class
