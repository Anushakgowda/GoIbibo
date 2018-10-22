package clubfactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClubFactory {

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.clubfactory.com/home.html");
		driver.findElement(By.xpath("//li[.='Sports & Fitness']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='active' or @class='']"));
	List<WebElement> list1 = list.subList(14,28);
		List<String> names = new ArrayList<>();
		for ( WebElement ele : list1) {
			String moduleName = ele.getText();
			if(moduleName.length()>0)
			names.add(moduleName);
		
		}
		System.out.println(names.size());
		for(String str : names)
		System.out.println(str);
		Collections.sort(names);
		System.out.println("=================================");
		for(String str : names)
		System.out.println(str);
		driver.close();
	}
}
