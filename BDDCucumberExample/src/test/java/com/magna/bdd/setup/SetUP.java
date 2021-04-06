package com.magna.bdd.setup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.magna.bdd.utils.AppConstants;

public class SetUP {

	public static WebDriver driver;
	public static final String AUTOMATE_USERNAME = "deepateststuff1";
	public static final String AUTOMATE_ACCESS_KEY = "TFRxSDWXsk82mo4L8uBy";

	public static final String REMOTE_URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	static String runMode = "local";

	public static WebDriver getDriver() {

		if (driver == null) {

			if (runMode.equalsIgnoreCase(AppConstants.APP_CONFIG_RUN_MODE_LOCAL)) {
				System.setProperty("webdriver.chrome.driver", "./res/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (runMode.equalsIgnoreCase(AppConstants.APP_CONFIG_RUN_MODE_REMOTE)) {
				try {
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability("os_version", "10");
					caps.setCapability("resolution", "1024x768");
					caps.setCapability("browser", "Chrome");
					caps.setCapability("browser_version", "88.0");
					caps.setCapability("os", "Windows");
					caps.setCapability("name", "jenkins Job"); // test name
					caps.setCapability("build", "Jenkins Build"); // CI/CD job or build name
					driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return driver;
	}
}
