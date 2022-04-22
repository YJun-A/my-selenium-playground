import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		List<WebElement> rows = driver.findElements(By.cssSelector("table.table-display tr"));
		System.out.println(rows.size());
		
		List<WebElement> columns = driver.findElements(By.cssSelector("table.table-display tr th"));
		System.out.println(columns.size());
		
		WebElement table = driver.findElement(By.id("product"));
		List<WebElement> secondRowValues = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		for(int i = 0 ; i < secondRowValues.size() ; i++) {
			
			System.out.println(secondRowValues.get(i).getText());
			
		}

	}//end of main

}//end of class
