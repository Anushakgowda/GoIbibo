package crafstvilla;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

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
		price.replace(" ", "").replaceAll("", "");
		System.out.println(price);
		int actualPrice=Integer.parseInt(price);
		try
		{
			Assert.assertTrue(actualPrice>=1000 && actualPrice<=2000,"Price is not within the range...");
			Reporter.log("Price is within the range...",true);
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
		driver.close();
		
	}
}
