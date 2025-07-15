/**
 * 
 */
package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
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
		loginPage.login("testuser", "testpass");
		try {
			Thread.sleep(3000); // just to observe, will remove later
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
