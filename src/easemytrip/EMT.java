package easemytrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class EMT {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("FromSector_show")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//span[contains(text(),'BLR')]")).click();
		driver.findElement(By.id("Editbox13_show")).sendKeys("Goa");
		driver.findElement(By.xpath("//span[contains(text(),'GOI')]")).click();
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.className("active-date")).click();
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		WebElement hp = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider')])[2]"));
		WebElement lp = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider')])[1]"));
		WebElement dt = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider')])[3]"));
		WebElement at = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider')])[6]"));
		Thread.sleep(6000);
		Actions action=new Actions(driver);
		action.clickAndHold(lp).moveByOffset(50,0).release().perform();
		action.clickAndHold(hp).moveByOffset(-20,0).release().perform();
		String r = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider')])[2]")).getText();
		String range = driver.findElement(By.id("amount")).getText();
		action.clickAndHold(dt).moveByOffset(80,0).release().perform();
		action.clickAndHold(at).moveByOffset(-40,0).release().perform();
		driver.findElements(By.xpath("//button[contains(text(),'Book')]")).get(2).click();
		String s = driver.findElement(By.xpath("(//span[contains(@ng-bind,'total')])[7]")).getText().replaceAll(",","");
		System.out.println(s);
		int price=Integer.parseInt(s);
		System.out.println(r);	
		driver.close();
	}

}
