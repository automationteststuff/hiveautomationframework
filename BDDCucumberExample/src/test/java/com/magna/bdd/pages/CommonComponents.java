package com.magna.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.magna.bdd.setup.SetUP;

public class CommonComponents {
	
	WebDriver driver;

	public CommonComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void launchBrowser() {
		SetUP.getDriver();
	}
	
	public void enterAppURL() {
		driver.get("https://www.westernunion.com/in/en/web/user/register");
		driver.navigate().refresh();
	}
	
	public void tearDown() {
		driver.quit();
	}
	
}
