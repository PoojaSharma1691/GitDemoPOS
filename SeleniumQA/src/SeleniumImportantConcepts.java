import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumImportantConcepts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1. Get count of all links present on above page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2. Get count of all link on footer section on above page -- limiting the
		// driver scope

		// div[@class= ' footer_top_agile_w3ls gffoot footer_style']//a
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		// 3. Get count of all links in 1st column "Discount coupon" section in above
		// footer

		WebElement column = footer.findElement(By.xpath("//td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());

		// 4 . Open all 4 windows above in seperate tab - using Ctrl+click which saves
		// time rather than navigating back and forth from browser and then clicking on
		// link

		for (int i = 1; i < column.findElements(By.tagName("a")).size(); i++) {
			String str = Keys.chord(Keys.CONTROL, Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(str);
			Thread.sleep(5000);
		}
		
		
		//5 . Open each link and get window title
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext())
		{
		driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());

	}
	}
}
