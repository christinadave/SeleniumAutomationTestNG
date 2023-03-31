package testcase;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;

public class OrderFlowTest extends BaseTest {

	@Test
	public static void orderflowTest() {

		Reporter.log("OrderFlowTest");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		driver.findElement(By.id(loc.getProperty("username_field"))).sendKeys("standard_user");
		driver.findElement(By.id(loc.getProperty("psw_field"))).sendKeys("secret_sauce");
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();

		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("addtocart_button")))).click();
		driver.findElement(By.className(loc.getProperty("shop_cart_button"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc.getProperty("checkout_button")))).click();
		driver.findElement(By.id(loc.getProperty("firstname_field"))).sendKeys("christina");
		driver.findElement(By.id(loc.getProperty("Lastname_field"))).sendKeys("dave");
		driver.findElement(By.id(loc.getProperty("Zipcode_field"))).sendKeys("1234");
		driver.findElement(By.name(loc.getProperty("continue_button"))).click();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(loc.getProperty("finish_button")))).click();
		;

	}

}
