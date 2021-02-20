package com.magna.bdd.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.magna.bdd.setup.SetUP;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;

public class Hooks {

	@AfterStep
	public void addScreenShotToreport(Scenario scenario) {

		try {
			byte[] screenShot = ((TakesScreenshot) SetUP.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenShot, "image/png");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
