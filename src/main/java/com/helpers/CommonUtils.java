package com.helpers;

import com.driver.DriverFactory;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class CommonUtils {

  private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);

  protected CommonUtils() {

  }

  protected static WebDriver getDriver() {
    return DriverFactory.getDriver();
  }

  protected static WebDriverWait getWait() {
    return new WebDriverWait(getDriver(), 20);
  }

  public static WebElement getElement(By locator) {
    return getDriver().findElement(locator);
  }

  protected static List<WebElement> getElements(By locator) {
    return getDriver().findElements(locator);
  }

  protected static void type(String value, By locator) {
    getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(value);
  }

  protected static void type(String value, WebElement element) {
    element.sendKeys(value);
  }

  protected static void click(By locator) {
    WebElement element = getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    highlightElement(element);
    element.click();
  }

  protected static void click(WebElement element) {
    getWait().until(ExpectedConditions.visibilityOf(element));
    highlightElement(element);
    element.click();
  }

  protected static String getText(By locator) {
    return getElement(locator).getText();
  }

  protected static String getText(WebElement element) {
    return element.getText();
  }

  protected static void clear(By locator) {
    getElement(locator).clear();
  }

  protected static void clear(WebElement element) {
    element.clear();
  }

  protected static By byTag(String name) {
    return By.tagName(name);
  }

  protected static By byClass(String name) {
    return By.className(name);
  }

  public static By byId(String name) {
    return By.id(name);
  }

  public static By byXpath(String name) {
    return By.xpath(name);
  }

  protected static By byCss(String name) {
    return By.cssSelector(name);
  }

  protected static By byLinkText(String name) {
    return By.partialLinkText(name);
  }

  protected static By byName(String name) {
    return By.name(name);
  }

  private static void highlightElement(WebElement element) {
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
  }

  public static void embedScreeenshotInTestReport(Scenario scenario) {
    try {
      scenario.log(scenario.getName());
      scenario.log(getDriver().getCurrentUrl());
      if (scenario.isFailed()) {
        scenario.attach(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
        takeScreenshot(scenario);
      }
    } catch (Exception e) {
      LOG.error("Error", e);
    }
  }

  public static void takeScreenshot(Scenario scenario) {
    try {
      File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("target/" + scenario.getName() + ".png"));
    } catch (Exception e) {
      LOG.error("Couldn't print a screenshot.", e);
    }
  }
}
