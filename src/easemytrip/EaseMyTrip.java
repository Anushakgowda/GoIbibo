package easemytrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EaseMyTrip {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.easemytrip.com/");
		driver.findElement(By.id("FromSector_show")).sendKeys("blr");
		driver.findElement(By.xpath("//span[contains(.,'Bangalore(BLR)')]")).click();
		driver.findElement(By.id("Editbox13_show")).sendKeys("goi");
		driver.findElement(By.xpath("//span[contains(.,'Goa')]")).click();
		driver.findElement(By.id("dvfarecal")).click();
		driver.findElement(By.xpath("//li[@class='active-date']")).click();
		driver.findElement(By.id("search")).click();
	}
}
