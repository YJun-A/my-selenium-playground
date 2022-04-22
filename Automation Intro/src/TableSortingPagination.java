import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSortingPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
		
		//1. Click on the column to sort the table
		
		WebElement vegFruitName = driver.findElement(By.xpath("//tr/th[1]"));
		vegFruitName.click();
		
		//2. Capture all web elements into list
		
		List<WebElement> vegeFruitColumn = driver.findElements(By.xpath("//tr/td[1]"));
		
		//3. Capture text of all web elements into new list (original)
		List<String> textList = vegeFruitColumn.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		//4. Sort on the original list -> creating sorted list
		List<String> sortedList = textList.stream().sorted().collect(Collectors.toList());
		
		//5. Compare original list to sorted list
		Assert.assertTrue(textList.equals(sortedList));
		
		//6. Scan the name column and get the price for "Beans"
		
		List<String> price;
		
		do {
			
			price = vegeFruitColumn.stream().filter(s -> s.getText().contains("Beans")).map(s -> getPrice(s)).collect(Collectors.toList());
			
			price.forEach(a -> System.out.println(a));
			
			if(price.size() < 1) {
				
				WebElement nextBTN = driver.findElement(By.xpath("//a[@arial-label='Next']"));
				nextBTN.click();
			}//if
			
		}//do
		while(price.size() < 1);
		
			
		

	}//main
	
	
	private static String getPrice(WebElement s) {
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return null;
		
	}

}//class
