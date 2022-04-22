import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEndPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Count of links in the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Count of links in just the footer section - limiting scope
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//3.Count of links in specific column in the footer section - limiting smaller scope
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		int columnLinkSize = column.findElements(By.tagName("a")).size();
		
		System.out.println(columnLinkSize);
		
		
		//4. Click on each link available in the column and check if the pages are opening
		for (int i = 1 ; i < columnLinkSize ; i++) {
			
			String controlKeyEnter = Keys.chord(Keys.CONTROL , Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(controlKeyEnter);
			Thread.sleep(5000);
			
		}//end of for
		
		
		//5. In each opened tab get the title
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> id = tabs.iterator();
		
		while(id.hasNext()){
			
			driver.switchTo().window(id.next());
			System.out.println(driver.getTitle());
			
		}
		
		
		driver.close();
		
	}//end of main

}//end of class
