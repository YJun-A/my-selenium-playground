import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarUIPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Calendar UI
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement departCalendarDate = driver.findElement(By.cssSelector("a[class='ui-state-default.ui-state-highlight']"));
		departCalendarDate.click();	
		
		WebElement roundTripRB = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		//WebElement returnCalendar = driver.findElement(By.id("ctl00_mainContent_view_date2"));
		
		//Assert.assertFalse(returnCalendar.isEnabled());
		roundTripRB.click();
		//Assert.assertTrue(returnCalendar.isEnabled());
		
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("Field is enabled. ");
			Assert.assertTrue(true);
			
		}
		else {
			
			Assert.assertTrue(false);
			
		}
		
		
		
		
	}//end of main

}//end of class
