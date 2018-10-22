package furlenco;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Furlenco {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.furlenco.com/");
		driver.findElement(By.xpath("//img[@alt='Bengaluru']")).click();
		driver.findElement(By.xpath("(//div[.='Living Room'])[2]")).click();
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("(//img[@class='  lazyautosizes lazyloaded'])[5]")).click();
		String price = driver.findElement(By.xpath("(//strong)[1]")).getText();
		System.out.println(price);
		driver.close();
	}
	
}
