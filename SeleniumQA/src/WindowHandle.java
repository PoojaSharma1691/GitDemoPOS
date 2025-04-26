import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText'][1]")).click();
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		String text=driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		//System.out.println(text);
		String email=text.split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("username")).sendKeys(email);
		

	}

}
