package com.stepdefs;

import com.helpers.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonUtils {

  @Before()
  public void beforeScenario() {
    getDriver().manage().window().maximize();
  }

  @After()
  public void embedReport(Scenario scenario) {
    embedScreeenshotInTestReport(scenario);
    getDriver().quit();
  }
}
