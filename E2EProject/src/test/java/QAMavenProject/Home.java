package QAMavenProject;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class Home extends Base {
	
	@DataProvider
	public Object[][] getData() {
		
		//Rows stand for how many different data types test should run with
		//Columns stand for how many values per test
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "abc123";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "123abc";
		
		return data;
		
	}//getData
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}//navigateTo
	
	@Test
	public void validateTitle(){

		LandingPage LP = new LandingPage(driver);
		Assert.assertEquals(LP.getTitle().getText(), "FEATURED COURSES");
				
	}//validateTitle
	
	@Test
	public void validateNavBar(){

		LandingPage LP = new LandingPage(driver);
		Assert.assertTrue(LP.getMenuNavBar().isDisplayed());
		
	}//validateNavBar
	
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username , String password){
	
		LandingPage LP = new LandingPage(driver);
		LP.getLogIn().click();
		
		LoginPage LGP = new LoginPage(driver);
		LGP.getEmailTextBox().sendKeys(username);
		LGP.getPasswordTextBox().sendKeys(password);
		LGP.getLoginButton().click();
		
	}//basePageNavigation
	
	
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
		
	}//closeBrowser

}//class
