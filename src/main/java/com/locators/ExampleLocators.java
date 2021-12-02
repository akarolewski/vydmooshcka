package com.locators;

import org.openqa.selenium.By;

import static com.helpers.CommonUtils.byId;
import static com.helpers.CommonUtils.byXpath;

public class ExampleLocators {

  public static final By SEARCH_INPUT = byId("searchInput");
  public static final By SUBMIT_SEARCH_BUTTON = byXpath("//button[@type = 'submit']");

  private ExampleLocators() {

  }
}
