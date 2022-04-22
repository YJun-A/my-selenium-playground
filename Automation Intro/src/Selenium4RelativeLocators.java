import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium4RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice");
		
		WebElement nameTB = driver.findElement(By.xpath("//[@name='name']"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameTB)).getText());
		
		WebElement dobTB = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(dobTB)).sendKeys("01/01/1990");
		
		WebElement icecreamCB = driver.findElement(By.xpath("//label[text()='Check me out if you love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamCB)).click();
		
		WebElement employment = driver.findElement(By.id("inlineRadio1"));
		
		driver.findElement(with(By.tagName("label")).toRightOf(employment)).getText();

	}//main

}//class
