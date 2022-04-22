package QAMavenProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import pageObjects.LandingPage;

public class Home3 extends Base {
	
	@Test
	public void validateNavBar() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage LP = new LandingPage(driver);
		Assert.assertTrue(LP.getMenuNavBar().isDisplayed());
		
	}//validateNavBar
	
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
		
	}//closeBrowser
	

}//class
