import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		WebElement dateCalendar = driver.findElement(By.id("travel_date"));
		dateCalendar.click();
		
		WebElement month = driver.findElement(By.cssSelector("div.datepicker-days th.datepicker-switch"));
		
		while(!month.getText().contains("April")) {
			
			WebElement calendarNext =  driver.findElement(By.cssSelector("div.datepicker-days th.next"));
			calendarNext.click();
			
		}//while
		
		
		
		
		List<WebElement> days = driver.findElements(By.className("day"));
		
		for(int i = 0 ; i < days.size() ; i++) {
			
			String text = driver.findElements(By.className("day")).get(i).getText();
			
			if(text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}//if
			
		}//for
		

	}//end of main

	
}//end of class
