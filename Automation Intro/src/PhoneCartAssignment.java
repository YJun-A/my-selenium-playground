import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhoneCartAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#okayBtn")));
		driver.findElement(By.cssSelector("button#okayBtn.btn.btn-success")).click();
		
		
		
		Select occupationDropdown = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		occupationDropdown.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav[class*='navbar-fixed-top'] a.navbar-brand")));
		
		String[] products = {"iphone X" , "Samsung Note 8" , "Nokia Edge" , "Blackberry"};
		
		addItem(driver, products);
		
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
		
		driver.close();
		
		
		

	}//end of main
	
	
	
	public static void addItem(WebDriver driver , String[] products) {
		
		List arrayList = Arrays.asList(products);
		
		List<WebElement> productMenu = driver.findElements(By.cssSelector("h4.card-title"));
		
		int loopCounter = 0;
		
		for (int i = 0; i < productMenu.size(); i++) {
			
			String productName = productMenu.get(i).getText();
			
			//productName.contentEquals("Cucumber")
			if (arrayList.contains(productName)) {
				
				loopCounter++;
				
				driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
				//break; -> cannot use break concept while using array list
				
				if(loopCounter == products.length)
					break;
				
			}//end of if
			
		}//end of for loop
		
		
	}//end of addItem

}//end of class
