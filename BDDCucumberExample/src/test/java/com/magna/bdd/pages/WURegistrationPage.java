package com.magna.bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WURegistrationPage {

	WebDriver driver;

	public WURegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id = 'firstName']") // driver.findElement(By.xpath("//input[@id = 'firstName']"));
	WebElement firstName;

	@FindBy(xpath = "//input[@id = 'middleName']")
	WebElement middleName;

	@FindBy(xpath = "//input[@id = 'lastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id = 'dob']")
	WebElement dob;
	
	@FindBy(xpath = "//button[@id = 'button-continue']")
	WebElement submitButton;

	// @FindBy(xpath = "//input[@id = 'dob']")
	// List<WebElement> list;

	public void verifyWURegPageLanding() {
		
		if (driver.getTitle().equals("Register a profile with Western Union IN")) {
			markTestStatus("passed", "Yaay title matched!", driver);
		} else {
			markTestStatus("failed", "Naay title did not match!", driver);
		}
		
		Assert.assertEquals("https://www.westernunion.com/in/en/web/user/register", driver.getCurrentUrl());
		Assert.assertEquals("Register a profile with Western Union IN", driver.getTitle());
	}
  
	public void clickOnSubmitButton() {
		submitButton.click();
	}

	public void enterFirstName(String firstNameText) throws InterruptedException {
		Thread.sleep(5000);
		firstName.sendKeys(firstNameText);
	}

	public void enterMiddleName(String middleNametext) {
		middleName.sendKeys(middleNametext);
	}

	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}

	public void enterDOB(String dobText) {
		dob.sendKeys(dobText);
		driver.quit();
	}
	
	public static void markTestStatus(String status, String reason, WebDriver driver) {
// 		JavascriptExecutor jse = (JavascriptExecutor) driver;
// 		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""
// 				+ status + "\", \"reason\": \"" + reason + "\"}}");
	}

}
