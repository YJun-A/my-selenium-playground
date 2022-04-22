import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Case_Demo {
	
	//Project = Test Suite
	//Class = Test Case

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Invoke Chrome browser for Selenium to interact with. Add ".exe" for Windows OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		
		//Create a driver object for targeted Chrome browser under test
		WebDriver driver = new ChromeDriver();
		
		//TO LAUNCH Firefox AS THE BROWSER UNDER TEST
		//Invoke Firefox browser for Selenium to interact with. Add ".exe" for Windows OS
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "//eclipse-workspace//geckodriver");
		//Create a driver object for targeted Firefox browser under test
		//WebDriver driver = new FirefoxDriver();
		
		//TO LAUNCH Microsoft Edge AS THE BROWSER UNDER TEST
		//Invoke Edge browser for Selenium to interact with. Add ".exe" for Windows OS
		//System.setProperty("webdriver.edge.driver", System.getProperty("user.home") + "//eclipse-workspace//msedgedriver");
		//Create a driver object for targeted Edge browser under test
		//WebDriver driver = new EdgeDriver();
		
		
		//Navigate to website under test
		driver.get("https://www.google.com/");
		
		//Get the web title and print it in console
		System.out.println("Website Title: " + driver.getTitle());
		
		//Ensure that the landed page is intended page
		System.out.println(driver.getCurrentUrl());
		
		//To get page source / DOM from the website when right click isnt enabled in the system
		//System.out.println(driver.getPageSource());
		
		//Navigate to another website under test
		driver.get("https://www.yahoo.com/");
		
		//Navigate back to the previous page, which is Google
		driver.navigate().back();
		
		//Following commands should not be used together at the same time
		//Close current browser
		driver.close();
		//Close all browsers opened by Selenium script
		//driver.quit();
		
		
	}

}
