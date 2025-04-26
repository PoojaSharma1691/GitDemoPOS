import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement ele=driver.findElement(By.xpath("((//table[@id='product'])[1]//td[3])[1]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		int rows=driver.findElements(By.xpath("(//table[@id='product'])[1]//tr")).size();
		System.out.println("Number of rows in table :"+rows);
		
		int columns=driver.findElements(By.xpath("(//table[@id='product'])[1]//th")).size();
		System.out.println("Number of columns in table :"+columns);
		
		System.out.println(driver.findElement(By.xpath("(//table[@id='product'])[1]//tr[3]")).getText());
		
		
	}

}
