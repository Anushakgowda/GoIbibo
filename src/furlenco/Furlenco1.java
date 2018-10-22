package furlenco;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Furlenco1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.furlenco.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]")).click();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Washing Machine");
		driver.findElement(By.xpath("(//img[@alt='Search'])[3]")).click();
		driver.findElement(By.xpath("//h1[contains(text(),'Wardrobe Washing Machine')]")).click();
		driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
		WebElement checkout = driver.findElement(By.xpath("//a[@data-action='checkout']"));
Actions actions=new Actions(driver);
actions.moveToElement(checkout);
Thread.sleep(1000);
driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
Thread.sleep(1000);
		//driver.findElement(By.xpath("//span[contains(text(),'LOGIN')]")).click();
WebElement frame = driver.findElement(By.xpath("//iframe[@id='hulk-login']"));
driver.switchTo().frame(frame);
Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Email ID')]")).sendKeys("7338108040");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		driver.switchTo().defaultContent();
		/*driver.findElement(By.xpath("(//a[contains(@href,'living')])[2]")).click();
		driver.findElements(By.xpath("//span[contains(text(),'Starts')]")).get(4).click();
		System.out.println("Product Name: "+driver.findElement(By.xpath("//h1[@itemprop='name']")).getText());
System.out.println("Product Description: "+driver.findElement(By.xpath("//div[@itemprop='description']")).getText());
		System.out.println("Base Pack Monthly Rental: "+driver.findElement(By.xpath("//strong[@class='package-price ng-scope ng-binding']")).getText());
	System.out.println("Value Pack: "+driver.findElement(By.xpath("(//span[@class='u-display-bl u-font-size-m-higher ng-binding'])[2]")).getText().substring(2));
	System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Minimum tenure')]")).getText());*/
	System.out.println("success");
		driver.close();
	}

}
