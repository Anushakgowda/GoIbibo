package bookmyshow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyShow {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/");
		driver.findElement(By.xpath("//a[contains(@onclick,'BANG')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[.='Not Now']")).click();
		driver.findElement(By.xpath("(//img[@class='__poster __animated'])[2]")).click();
//		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//a[@class='showtimes btn _cuatro']")).click();
		driver.findElement(By.xpath("//span[.='TOM']")).click();
		driver.findElement(By.xpath("(//a[@class='__showtime-link  time_vrcenter '])[1]")).click();
		driver.findElement(By.id("btnPopupAccept")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='action-btn']")).click();
		driver.findElement(By.xpath("//a[@class='_available']")).click();
	}
}
