package crafstvilla;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Craftsvil {

	static {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	}
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.craftsvilla.com/");
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//click on saree module
		driver.findElement(By.linkText("SAREES")).click();
		Thread.sleep(5000);
		
		//select the filter 1000-2000
		driver.findElement(By.xpath("//label[@title='1000-2000']")).click();
		Thread.sleep(5000);
		
		//click on 3rd product
		driver.findElement(By.xpath("(//div[@class='col-xs-12 product'])[3]")).click();
		
		//get the price of that
		WebElement price = driver.findElement(By.className("pdp-offer-price"));
		System.out.println("price of 3rd element= "+price.getText());
		driver.close();
}
}
