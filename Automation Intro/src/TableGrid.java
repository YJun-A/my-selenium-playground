import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableGrid {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement tableScroll = driver.findElement(By.cssSelector(".tableFixHead"));
		
		js.executeScript("window.scrollBy(0,500)", tableScroll);
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> tableAmountValue = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum = 0;
		
		for(int i = 0 ; i < tableAmountValue.size() ; i++) {
			
			int value = Integer.parseInt(tableAmountValue.get(i).getText());
			
			 sum += value;
			 
		}
		
		System.out.println(sum);
		
		WebElement totalSum = driver.findElement(By.cssSelector(".totalAmount"));
		int sumValue = Integer.parseInt(totalSum.getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, sumValue);
		

	}//end of main

}//end of class
