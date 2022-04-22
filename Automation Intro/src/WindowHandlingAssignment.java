import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles(); 
		Iterator<String> windowID = windows.iterator();
		String parentID = windowID.next();
		String childID = windowID.next();
		
		
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		
		driver.quit();
		

	}//end of main

}//end of class
