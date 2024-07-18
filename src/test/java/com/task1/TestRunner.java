package com.task1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.basetest.BaseClass;
import com.pom.LoginPage;
import com.pom.SecureAreaPage;

public class TestRunner extends BaseClass {
	public static WebDriver driver = BaseClass.browserLaunch();
	public static LoginPage loginPage = new LoginPage(driver);
	public static SecureAreaPage secureAreaPage = new SecureAreaPage(driver);

	@Test
	public void testLogin() {
		getUrl("https://the-internet.herokuapp.com/");
		clickOnElement(loginPage.getFormAuthentication());
		inputValueElement(loginPage.getUsername(), "tomsmith");
		inputValueElement(loginPage.getPassword(), "SuperSecretPassword!");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		clickOnElement(loginPage.getLogin());

		String actualText = gettingText(secureAreaPage.getSuccessText());

		actualText=actualText.replaceAll("×", "");
		String expectedText="You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
		clickOnElement(secureAreaPage.getLogout());

	}
	
  @AfterClass
  public void tearDown() {
      if (driver != null) {
          driver.quit();
      }
  }
}
