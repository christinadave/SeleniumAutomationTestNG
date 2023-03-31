package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import utilities.ReadXLSdata;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "SLdata")
	public static void LoginData(String username, String password) throws InterruptedException {

		driver.findElement(By.id(loc.getProperty("username_field"))).sendKeys(username);
		
		driver.findElement(By.id(loc.getProperty("psw_field"))).sendKeys(password);
		
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
		

	}
	
	@DataProvider(name="SLdata")
	public Object[][] testData() {
		
		return new Object[][] { 
			{"standard_user", "secret_sauce"}, 
			{"locked_out_user", "secret_sauce"},
			{"problem_user", "secret_sauce"} 
			};
	}

}
