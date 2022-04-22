import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.apache.commons.io.FileUtils;

public class SSLCheck {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		//FirefoxOptions options1 = new FirefoxOptions();
		//EdgeOptions options2 = new EdgeOptions();
		
		//options.addExtensions(new File("/file/path.crx"));
		
		//Proxy proxy = new Proxy();
		//proxy.setHttpProxy("IPaddress:xxxx");
		//options.setCapability("proxy", proxy);
		
		options.setAcceptInsecureCerts(true);
		
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//Map<String,Object> prefs = new HashMap<String, Object>();
		//prefs.put("download.default.directory", "/directory/path");
		//options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com");
		
		//To delete browser cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("xxxx");
		
		//To take screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.home") + "//screenshot.png"));

		
		
	}//end of main

}//end of class
