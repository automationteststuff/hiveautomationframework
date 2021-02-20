package com.magna.bdd.steps;

import com.magna.bdd.pages.WURegistrationPage;
import com.magna.bdd.setup.SetUP;

import io.cucumber.java.en.Then;

public class WURegistrationSteps {

	WURegistrationPage regPage = new WURegistrationPage(SetUP.getDriver());
	
	@Then("verify user landing on home page")
	public void verify_user_landing_on_home_page() {
		regPage.verifyWURegPageLanding();
	}

	@Then("user click on submit button on the bottom of the section")
	public void user_click_on_submit_button_on_the_bottom_of_the_section() {
		regPage.clickOnSubmitButton();
	}

	@Then("user enters first name as (.*)")
	public void user_enters_first_name(String firstname) throws Exception{
		regPage.enterFirstName(firstname);
	}

	@Then("user enters middle name as (.*)")
	public void user_enters_middle_name(String middleName) {
		regPage.enterMiddleName(middleName);
	}

	@Then("user enters last name as (.*)")
	public void user_enters_last_name(String lastName) {
		regPage.enterLastName(lastName);
	}

	@Then("user enters date of birth as (.*)")
	public void user_enters_date_of_birth_as(String dob) {
		regPage.enterDOB(dob);
	}	

}
