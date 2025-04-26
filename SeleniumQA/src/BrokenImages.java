import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages {

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		List<WebElement> images = driver.findElements(By.tagName("img"));

        // Check each image
        for (WebElement img : images) {
            String imgUrl = img.getDomAttribute("src");
            if (imgUrl != null && !imgUrl.isEmpty()) {
                checkImage(imgUrl);
            }
        }

        // Close the WebDriver
        driver.quit();
    }

    // Method to check if an image is broken
    private static void checkImage(String imgUrl) throws URISyntaxException {
        try {
            // Create a URL object from the image URL
        	URI uri=new URI(imgUrl);
            URL url = uri.toURL();

            // Open a connection to the image URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to HEAD to only get headers (faster than GET)
            connection.setRequestMethod("HEAD");

            // Set a timeout to avoid hanging indefinitely
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Connect and get the response code
            int responseCode = connection.getResponseCode();

            // If response code is not 200, the image is broken
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Broken image found: " + imgUrl + " (Status code: " + responseCode + ")");
            } else {
                System.out.println("Valid image: " + imgUrl);
            }

            // Disconnect the connection
            connection.disconnect();
        } catch (IOException e) {
            // If there is an exception, print the error (invalid URL, network error, etc.)
            System.out.println("Error with image " + imgUrl + ": " + e.getMessage());
        }
		

}
}
