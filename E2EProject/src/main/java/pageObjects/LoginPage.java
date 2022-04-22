package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}//constructor
	
	@FindBy (id = "user_email")
	WebElement emailTB;
	
	@FindBy (id = "user_password")
	WebElement passwordTB;
	
	@FindBy (name = "commit")
	WebElement loginBTN;


	
	
	public WebElement getEmailTextBox() {
		
		return emailTB;
		   
	}//getEmailTextBox
	
	public WebElement getPasswordTextBox() {
		
		return passwordTB;
		   
	}//getPasswordTextBox
	
	public WebElement getLoginButton() {
		
		return loginBTN;
		   
	}//getPasswordTextBox
	
	

}//class
