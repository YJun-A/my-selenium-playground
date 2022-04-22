import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebElement otherLink = driver.findElement(By.cssSelector(".blinkingText"));
		otherLink.click();
		
		Set<String> windows = driver.getWindowHandles(); //[parentID , childID , subChildID]
		Iterator<String> windowID = windows.iterator();
		String parentID = windowID.next();
		String childID = windowID.next();
		String subChildID = windowID.next();
		driver.switchTo().window(childID);
		
		WebElement msg = driver.findElement(By.cssSelector(".im-para.red"));
		String formattedMsg = msg.getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentID);
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(formattedMsg);
		
		

	}//end of main

}//end of class
