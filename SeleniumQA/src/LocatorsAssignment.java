import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Pooja");
		driver.findElement(By.name("email")).sendKeys("postest@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
		driver.findElement(By.id("exampleCheck1")).click();
		Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dropdown.selectByVisibleText("Female");
		driver.findElement(By.xpath(("//label[text()=\"Student\"]"))).click();
		driver.findElement(By.name("bday")).sendKeys("16-01-1991");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		System.out.println(driver.findElement(By.xpath("//div/strong")).getText());
		driver.close();
	}

}
