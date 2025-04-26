import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSort {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[@href='#/offers']")).click();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		
		driver.findElement(By.xpath("//th[1]")).click();
		// capture elements without sorting
		List<WebElement> originalList = driver.findElements(By.xpath("//tbody//tr"));
		List<String> orgList = originalList.stream().map(s -> s.getText()).collect(Collectors.toList());
		Thread.sleep(3000);	

		//

		// capture elements after sorting on web table
	
		List<String> newList = orgList.stream().sorted().collect(Collectors.toList());

		if (orgList.equals(newList)) {
			System.out.println("Sorting working fine");
		} else {
			System.out.println("Sorting not working");
		}
		
		Assert.assertEquals(orgList, newList);
	}

}
