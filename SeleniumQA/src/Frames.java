import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();

		driver.switchTo().frame(0);
		int n = driver.findElements(By.tagName("frame")).size();
		//System.out.println(n);
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")).getText());
		
		

	}

}
