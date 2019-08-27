import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkTest {
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
//
//		WebElement user = driver.findElement(By.name("username"));
//		user.sendKeys("Anurag123");
//
//		WebElement pass = driver.findElement(By.name("password"));
//		pass.sendKeys("Anurag123");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		1. Get the list of all the links and Images

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Size of full links and images  " + linksList.size());

		List<WebElement> activeLinks = new ArrayList<WebElement>();

//		2. iterate linksList : Exclude which doesn't have any href attribute

		for (int i = 0; i < linksList.size(); i++) {
			System.out.println("888888888   " + linksList.get(i).getAttribute("href"));
			if (linksList.get(i).getAttribute("href") != null
					&& (!linksList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linksList.get(i));
			}
		}

		System.out.println("Size of active links and images  " + activeLinks.size());

		for (int j = 0; j < activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "---->" + response);

		}

	}
}
