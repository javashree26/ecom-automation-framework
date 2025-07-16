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
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

/**
 * @author dhanashree
 *
 */
public class LoginTest extends BaseTest {

	// using enabled = false approach to skip this test scenario
	@Test(enabled = false)
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

	@Test
	public void testInvalidUser() {
		// using skipexception to skip this test scenario
		boolean skip = true;
		if (skip) {
			throw new SkipException("Skipping this test scenario for this test run.");
		}
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("crash_543", "crash_546");

		String alertText = loginPage.getLoginAlertText();
		Assert.assertEquals(alertText, "User does not exist.");
	}

	@Test(enabled = true)
	public void testInvalidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("test", "test123");

		String alertString = loginPage.getLoginAlertText();
		Assert.assertEquals(alertString, "Wrong password.");
	}
}
