/**
 * 
 */
package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author dhanashree
 *
 */
public class LoginPage {

	private WebDriver driver;

	// locators
	private By loginButton = By.id("login2");
	private By loginPopup = By.id("logInModal");
	private By usernameField = By.id("loginusername");
	private By passwordField = By.id("loginpassword");
	private By submitButton = By.xpath("//button[text()='Log in']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// page actions
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	// validate if popup is open and enter details
	public void waitForLoginPopup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPopup));
	}

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);

	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}

	public void login(String username, String password) {
		clickLoginButton();
		waitForLoginPopup();
		enterUsername(username);
		enterPassword(password);
		clickSubmitButton();
	}

	public String getLoginAlertText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;

	}
}
