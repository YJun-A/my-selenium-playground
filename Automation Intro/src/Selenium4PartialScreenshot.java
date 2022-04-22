import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4PartialScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice");
		
		WebElement nameTB = driver.findElement(By.xpath("//[@name='name']"));
		File sc = nameTB.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(sc, new File("logo.png"));
		
		
		//To get height and width of element
		int height = nameTB.getRect().getDimension().getHeight();
		int width = nameTB.getRect().getDimension().getWidth();

	}//class

}//class
