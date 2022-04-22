import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Static drop down - options are fixed
		WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//Drop down with <select> tag
		Select dropdown = new Select(currencyDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		
		
		//UI drop down
		WebElement passengerDropdown = driver.findElement(By.id("divpaxinfo"));
		WebElement passengerIncrement = driver.findElement(By.id("hrefIncAdt"));
		WebElement passengerDone = driver.findElement(By.id("btnclosepaxoption"));
		int passengerPax = 5;
		
		passengerDropdown.click();
		Thread.sleep(2000);
		
		int i = 1;
		while(i <= passengerPax) {
			
			passengerIncrement.click();
			i++;
			
		}
		passengerDone.click();
		System.out.println(passengerDropdown.getText());
		
		
		//Dynamic drop down
		WebElement fromDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1"));
		//WebElement toDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1"));
		WebElement MAAdropdownOption = driver.findElement(By.xpath("//a[@value='MAA']"));
		//WebElement BLRdropdownOption = driver.findElement(By.xpath("(//a[@value='BLR'])[2]"));
		WebElement BLRdropdownOption = driver.findElement(By.xpath("(//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR'])"));
		
		fromDropdown.click();
		Thread.sleep(2000);
		MAAdropdownOption.click();
		Thread.sleep(2000);
		BLRdropdownOption.click();
		
		
		//Auto Suggestive drop down
		WebElement suggestiveCountryText = driver.findElement(By.id("autosuggest"));
		List<WebElement> suggestiveCountryOptions =  driver.findElements(By.cssSelector("li[class='ui-menu-item] a"));
		
		suggestiveCountryText.sendKeys("ind");
		Thread.sleep(2000);
		
		for(WebElement option : suggestiveCountryOptions) {
			
			if (option.getText().equalsIgnoreCase("India")){
				option.click();
				break;
			}
			
		}//end of for
		
		
		//Check box
		WebElement seniorCitizenCheckbox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		
		Assert.assertFalse(seniorCitizenCheckbox.isSelected());
		seniorCitizenCheckbox.click();
		//System.out.println(seniorCitizenCheckbox.isSelected());
		Assert.assertTrue(seniorCitizenCheckbox.isSelected());
		
		//count the number of check box
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		
	}//end of main

}//end of class
