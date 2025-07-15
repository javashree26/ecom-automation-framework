/**
 * 
 */
package com.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

/**
 * @author dhanashree
 *
 */
public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {

		LoginPage loginPage = new LoginPage(driver);

		// perform actual login
		loginPage.login("test", "test");

		// verifying whether login is successful
		HomePage homePage = new HomePage();
		Assert.assertTrue(homePage.isLogoutButtonVisible(driver),
				"Login might have failed — logout button not visible");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = false)
	public void testInvalidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("crash_1230", "crash_987");

		String alertText = loginPage.getLoginAlertText();
		Assert.assertEquals(alertText, "User does not exist.");
	}
}
