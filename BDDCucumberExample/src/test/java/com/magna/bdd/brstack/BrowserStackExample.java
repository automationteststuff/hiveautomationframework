package com.magna.bdd.brstack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackExample {

	public static final String AUTOMATE_USERNAME = "deepateststuff1";
	public static final String AUTOMATE_ACCESS_KEY = "TFRxSDWXsk82mo4L8uBy";

	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "2048x1536");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "88.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("name", "Automation Hive Sample Test"); // test name
		caps.setCapability("build", "Hive Build 1"); // CI/CD job or build name

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		driver.get("https://www.google.com");

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("BrowserStack");
		element.submit();

		System.out.println(driver.getTitle());
		// Setting the status of test as 'passed' or 'failed' based on the condition; if
		// title of the web page starts with 'BrowserStack'
		if (driver.getTitle().substring(0, 12).equals("BrowserStack")) {
			markTestStatus("passed", "Yaay title matched!", driver);
		} else {
			markTestStatus("failed", "Naay title did not match!", driver);
		}
		driver.quit();
	}

	// This method accepts the status, reason and WebDriver instance and marks the
	// test on BrowserStack
	public static void markTestStatus(String status, String reason, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""
				+ status + "\", \"reason\": \"" + reason + "\"}}");
	}

}
