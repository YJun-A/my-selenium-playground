import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment8AutoCompleteDropdown {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement suggestiveDropdown = driver.findElement(By.id("autocomplete"));
		suggestiveDropdown.sendKeys("ind");
		Thread.sleep(2000);
		
		String selection = "India";
		
		List<WebElement> suggestiveCountryOptions =  driver.findElements(By.cssSelector("li.ui-menu-item div"));
		
		for(WebElement option : suggestiveCountryOptions) {
		     if (option.getText().equalsIgnoreCase(selection)) {
		          option.click();
		          break;
		     }
		}
		
		Assert.assertEquals(suggestiveDropdown.getAttribute("value"), selection);

		
	}//end of main

}//end of class
