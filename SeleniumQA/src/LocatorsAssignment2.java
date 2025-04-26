import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorsAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();

		String text = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/..")).getText();
		System.out.println(text);
		
		Select dropdown= new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(text);
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		String str=driver.switchTo().alert().getText();
		System.out.println(str);
		if(str.contains(text))
		{
			System.out.println("Alert is correct");
			driver.switchTo().alert().accept();
		}
		else
			System.out.println("Alert not correct");

	}

}
