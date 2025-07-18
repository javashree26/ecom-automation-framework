/**
 * 
 */
package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author dhanashree
 *
 */
public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// setting up browser driver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// maximise browser window and set timeouts
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// open the test site
		driver.get(Constants.BASE_URL); // sample e-commerce site, not working anymore

	}

	@AfterMethod
	public void tearDown() {

		// close browser after test
		if (driver != null) {
			driver.quit();
		}
	}
}
