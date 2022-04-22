import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// get() -> by default Selenium will wait for the page to be properly loaded
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// navigate().to() -> will not wait for page to be fully loaded, need implicit or explicit wait
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
		
	}//end of main

}//end of class
