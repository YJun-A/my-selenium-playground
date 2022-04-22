package QAMavenProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import pageObjects.LandingPage;

public class Home2 extends Base {
	
	@Test
	public void validateTitle() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage LP = new LandingPage(driver);
		Assert.assertEquals(LP.getTitle().getText(), "Featured Courses");
				
	}//validateTitle
	
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
		
	}//closeBrowser

}//class