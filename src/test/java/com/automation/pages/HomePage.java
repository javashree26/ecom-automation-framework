/**
 * 
 */
package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BaseTest;

/**
 * @author dhanashree
 *
 */
public class HomePage extends BaseTest {
	private WebDriver driver;

	// locators
	private By logoutButton = By.id("logout2");

//	public HomePage(WebDriver driver) {
//		this.driver = driver;
//	}

	public boolean isLogoutButtonVisible(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();

	}
}
