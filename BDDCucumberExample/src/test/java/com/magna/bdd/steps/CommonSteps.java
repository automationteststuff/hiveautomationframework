package com.magna.bdd.steps;

import org.openqa.selenium.WebDriver;

import com.magna.bdd.pages.CommonComponents;
import com.magna.bdd.setup.SetUP;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps {

//	WebDriver driver;
	CommonComponents cmp = new CommonComponents(SetUP.getDriver());

	@Given("User launch the chrome broswer")
	public void user_launch_the_broswer() {
		cmp.launchBrowser();
	}

	@When("user enter the application url")
	public void user_enter_the_application_url() {
		cmp.enterAppURL();
	}

	@Then("user closes the apllication")
	public void user_closes_the_apllication() {
//		cmp.tearDown();
	}
}
