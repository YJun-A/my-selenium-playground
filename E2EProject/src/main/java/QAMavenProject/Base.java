package QAMavenProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	WebDriver driver;
	
	Properties prop = new Properties(); //needs to be declared in class level for it to be accessed in class(s) that inherits (extends) Base class
	
	public WebDriver initializeDriver() throws IOException {
		
		String propertiesFilePath = System.getProperty("user.home") + "/eclipse-workspace/E2EProject/src/main/java/resources/data.properties";
		FileInputStream fis = new FileInputStream(propertiesFilePath);
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		switch(browserName.toLowerCase()) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
			driver = new ChromeDriver();
			
			break;
		
		
		case "edge":
			System.setProperty("webdriver.msedge.driver", System.getProperty("user.home") + "//eclipse-workspace//msedgedriver");
			driver = new EdgeDriver();
			
			break;
		
		default:
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
			driver = new ChromeDriver();
			
			break;
		
		}//switch
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); -> deprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}//intializeDriver

}//class
