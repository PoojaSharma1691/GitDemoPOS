import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class introduction {

	public static void main(String[] args) {
		
		
		//ChromeDriver driver=new ChromeDriver();
		//WebDriver driver=new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
		WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
		
		
		

	}

}
