import java.time.Duration;
import java.util.Arrays;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CartPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']//following-sibling::span")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		Select dropdown=new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Checkout')]")));
		
		List<WebElement> products=driver.findElements(By.xpath("//button[contains(text(),'Add')]"));
		
		for(WebElement e : products)
		{
			e.click();
		}
		
		String[] text=driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).getText().split("\\(");
		text[1].trim();
		String[] subtext=text[1].split(" ");
		System.out.println(subtext[1]);
		int n=Integer.parseInt(subtext[1]);
		if(n==products.size())
		{
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Checkout')]")));
			driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		}
		
		
		
		
	}

}
