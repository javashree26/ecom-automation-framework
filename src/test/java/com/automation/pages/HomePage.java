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
	private By contactLink = By.xpath("//a[text()='Contact']");
	private By cartLink = By.xpath("//a[text()='Cart']");
	private By welcomeLink = By.xpath("//a[starts-with(text(), 'Welcome')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogoutButtonVisible(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();

	}

	public boolean isContactLinkVisible(WebDriver driver) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return driver.findElement(contactLink).isDisplayed();
	}

	public boolean isCartLinkVisible(WebDriver driver) {

		return driver.findElement(cartLink).isDisplayed();

	}

	public boolean isWelcomeLinkVisible(WebDriver driver) {
		return driver.findElement(welcomeLink).isDisplayed();

	}

}
