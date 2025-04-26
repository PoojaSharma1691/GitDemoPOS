import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String veggie="Rice";
		
		driver.findElement(By.id("search-field")).sendKeys(veggie);
		
		List<WebElement> list=driver.findElements(By.xpath("//tr//td[1]"));
		List<WebElement> vegResult=list.stream().filter(s->s.getText().contains(veggie)).collect(Collectors.toList());
		
		Assert.assertEquals(list, vegResult);
	}

}