import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ecart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(2000);
		
		String[] products = {"Cucumber" , "Cauliflower"};
		
		addItemIntoCart(driver, products);
		
		WebElement cart = driver.findElement(By.cssSelector("img[alt='Cart']"));
		cart.click();
		
		WebElement checkout = driver.findElement(By.xpath("//div[contains(@class,'cart-preview')]/div[@class='action-block']/button"));
		checkout.click();
		
		WebElement promo = driver.findElement(By.cssSelector("input.promoCode"));
		promo.sendKeys("rahulshettyacademy");
		
		WebElement applyPromo = driver.findElement(By.cssSelector("button.promoBtn"));
		applyPromo.click();
		
		
		WebElement promoMsg = driver.findElement(By.cssSelector("span.promoInfo"));
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		Assert.assertTrue(promoMsg.isDisplayed());
		
		
		driver.close();
		
		
		
		

	}//end of main
	
	
	
	
	public static void addItemIntoCart(WebDriver driver, String[] products) {
		
		
		List arrayList = Arrays.asList(products);
		
		List<WebElement> productMenu = driver.findElements(By.cssSelector("h4.product-name"));
		
		int loopCounter = 0;
		
		for (int i = 0; i < productMenu.size(); i++) {
			
			String[] productName = productMenu.get(i).getText().split("-");
			String formattedProductName = productName[0].trim();
			
			//productName.contentEquals("Cucumber")
			if (arrayList.contains(formattedProductName)) {
				
				loopCounter++;
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//break; -> cannot use break concept while using array list
				
				if(loopCounter == products.length)
					break;
				
			}//end of if
			
		}//end of for loop
		
	}//end of addItemIntoCart
	
	

}//end of class
