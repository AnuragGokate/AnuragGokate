import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Where we use actual HashMap in Selenium ?

public class HashMapInSelenium {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.crmpro.com");
		System.out.println(getCredentialsMap());
		System.out.println(getCredentialsMap().get("distributor"));
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(getUserName("distributor"));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(getPassword("distributor"));
	}

	
	public static HashMap<String, String> getCredentialsMap() {
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("customer", "anurag:anurag@123");
		userMap.put("admin", "arpit:arpit123");
		userMap.put("distributor", "gulhane:gulhane123");
		userMap.put("seller", "chetna:chetna@123");
		userMap.put("deliverygirl", "greeshma:greeshma@134");
		return userMap;
	}
	
	public static String getUserName(String role) {
	String credential = getCredentialsMap().get(role);
	return credential.split(":")[0];
	}
	
	public static String getPassword(String role) {
		String credential = getCredentialsMap().get(role);
		return credential.split(":")[1];
		}
}
