import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		SoftAssert sa=new SoftAssert();
		
		List<WebElement> links=driver.findElements(By.xpath("//div[@id='gf-BIG']//td//li//a"));
		for(WebElement link:links)
		{
			String urltext=link.getDomAttribute("href");
			URI uri=new URI(urltext);
			URL url=uri.toURL();
			
			URI baseUri = new URI(driver.getCurrentUrl());
            uri = baseUri.resolve(uri);
			HttpURLConnection   conn= (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("HEAD"); //provides only header information and not body
			conn.connect();			
			int code=conn.getResponseCode();
			Assert.assertTrue(code>=400, "URL is broken : "+url); //Hard Asserstion - script will fail here if code>=400 and furter execution will stop
			//sa.assertTrue(code>=400, "URL is broken : "+url);
	
			
			
		}
		sa.assertAll();

	}

}
