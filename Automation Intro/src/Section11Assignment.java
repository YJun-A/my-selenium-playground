import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Section11Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement checkbox = driver.findElement(By.cssSelector("input#checkBoxOption2"));
		checkbox.click();
		
		String checkboxLabel = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText().trim();
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdownList = new Select(dropdown);
		dropdownList.selectByVisibleText(checkboxLabel);
		
		WebElement alertTB = driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));
		alertTB.sendKeys(checkboxLabel);
		
		WebElement alertBTN = driver.findElement(By.cssSelector("input#alertbtn"));
		alertBTN.click();
		
		String alertText = driver.switchTo().alert().getText();
		
		Assert.assertTrue(alertText.contains(checkboxLabel));
		

	}//end of main

}//end of class
