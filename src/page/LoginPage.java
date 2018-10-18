package page;

import java.time.LocalDateTime;
import java.time.Month;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver ; 
	
	@FindBy(xpath="(//input[@placeholder=\"Choose Date\"])[1]")
	private WebElement departDate;
	
	@FindBy(xpath="(//input[@placeholder=\"Choose Date\"])[2]")
	private WebElement returnDate;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setDepartDate() {
		departDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time);
		Month month = time.getMonth();
		System.out.println(month);
		
	}
	
}
