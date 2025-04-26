import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartEcommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5))

		Thread.sleep(3000);
		String[] items = { "Cucumber", "Brocolli", "Beetroot", "Carrot", "Tomato" };
		addItemsToCart(items, driver);
		clickAddToCart(driver);
		driver.close();

	}

	public static void addItemsToCart(String[] s, WebDriver driver) {

		int j = 0;
		List<String> itemsToAdd = Arrays.asList(s);

		List<WebElement> ele = driver.findElements(By.xpath("//h4[@class='product-name']"));
		// System.out.println(driver.findElements(By.xpath("//h4[@class='product-name']")).get(0).getText());

		for (int i = 0; i < ele.size(); i++) {
			String[] name = ele.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// List<String> itemsToAdd = Arrays.asList(items);

			if (itemsToAdd.contains(formattedName)) {
				j++;
				driver.findElement(By.xpath("//h4[contains(text(),'" + formattedName + "')]/..//button")).click();
				if (j == s.length)
					break;
			}

		}

	}

	public static void clickAddToCart(WebDriver driver) {
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
	}
}
