package pack;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoIbibo {
	static{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();  
        System.out.println("Before Formatting: " + now);  
       /* DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = now.format(format);  */
        //System.out.println("After Formatting: " + formatDateTime);
        LocalDate time = LocalDate.now();
        System.out.println(time);
        int day1 = now.getDayOfMonth();
        int day2=0;
        int day=0;
		Month mon1 = now.getMonth();
		String mon = mon1.toString();
		System.out.println(mon);
		if(mon.equals("APRIL")||mon.equals("JUNE")||mon.equals("SEPTEMBER")||mon.equals("NOVEMBER"))
		{ //mod is used to calculate the data 
			day=day1;
		day2=(day1+50)%30;
		}
		else if(mon.equals("JANUARY")||mon.equals("MARCH")||mon.equals("MAY")||mon.equals("JULY")||mon.equals("AUGUST")||mon.equals("OCTOBER")||mon.equals("DECEMBER"))
		{
			day=day1-1;
			day2=(day1+50)%31;
		}
		else{
			day=day1+2;
		}
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.goibibo.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[contains(@placeholder,'Choose')])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='"+day+"'])[2]")).click();
		driver.findElement(By.xpath("(//input[contains(@placeholder,'Choose')])[2]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'DayPicker-NavButton')]")).click();
		driver.findElement(By.xpath("(//div[text()='"+day2+"'])[2]")).click();
		driver.close();

	}
}