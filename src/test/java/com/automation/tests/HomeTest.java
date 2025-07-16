/**
 * 
 */
package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;

/**
 * @author dhanashree
 *
 */
public class HomeTest extends BaseTest {

	@Test
	public void verifyContactLinkIsVisible() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isContactLinkVisible(driver), "Contact link is not visible on homepage.");
	}

	@Test
	public void verifyIfOtherLinksVisible() {
		HomePage homePage = new HomePage(driver);
		SoftAssert softAssert = new SoftAssert();
		// check all links
		softAssert.assertTrue(homePage.isCartLinkVisible(driver), "Cart link is not visible");
		softAssert.assertTrue(homePage.isWelcomeLinkVisible(driver), "Welcome user is not visible");
		softAssert.assertAll();
	}
}
