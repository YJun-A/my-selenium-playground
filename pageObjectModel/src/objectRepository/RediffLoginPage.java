package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	
	WebDriver driver;
	
	public RediffLoginPage (WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By username = By.xpath(".//*[id='login1']");
	By password = By.name("passwd");
	By signIn = By.name("proceed");
	
	
	public WebElement usernameID() {
		
		return driver.findElement(username);
	}
	
	public WebElement passwordName() {
		
		return driver.findElement(password);
	}
	
	public WebElement signInButton() {
		
		return driver.findElement(signIn);
	}
	
	

}//class
