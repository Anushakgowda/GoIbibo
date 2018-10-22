package crafstvilla;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CraftsVilla {

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.craftsvilla.com/");
		driver.findElement(By.xpath("//a[.='SAREES']")).click();
		driver.findElement(By.xpath("//label[@title='1000-2000']")).click();
//		String priceRange = range.getAttribute("title");
//		System.out.println(priceRange);
//		range.click();
		driver.findElement(By.xpath("(//img[@class='product-image lazy'])[3]")).click();
		String price = driver.findElement(By.xpath("//span[@class='pdp-offer-price']")).getText();
		System.out.println(price);
//		driver.close();
		
	}
}
