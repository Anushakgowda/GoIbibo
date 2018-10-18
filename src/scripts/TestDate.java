package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.LoginPage;

public class TestDate extends BaseTest{

	@Test
	void TestDates() {
	LoginPage login = new LoginPage(driver);
	login.setDepartDate();
	
	}
}
