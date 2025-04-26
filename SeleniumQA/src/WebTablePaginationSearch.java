import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePaginationSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[@href='#/offers']")).click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);

		String veggie = "Almond";
		String price;

		List<String> veggiePrice;
		do {
			List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
			veggiePrice = list.stream().filter(s -> s.getText().contains(veggie)).map(s -> getVeggiePrice(veggie, s))
					.collect(Collectors.toList());
			veggiePrice.forEach(s->System.out.println(s));

			if (veggiePrice.size() < 1)
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		} while (veggiePrice.size() < 1);

	}

	public static String getVeggiePrice(String veggie, WebElement ele) {
		String price = ele.findElement(By.xpath("//td[1][contains(text(),'" + veggie + "')]/following-sibling::td[1]"))
				.getText();
		return price;
	}

}
