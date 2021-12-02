package com.driver;

import org.openqa.selenium.WebDriver;

import static com.driver.DriverSetup.localChrome;

public class DriverFactory {

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  private DriverFactory() {

  }

  public static synchronized WebDriver getDriver() {
    if (driver.get() == null || driver.get().toString().contains("(null)")) {
      setWebDriver(localChrome());
    }
    return driver.get();
  }

  private static synchronized void setWebDriver(WebDriver driver) {
    DriverFactory.driver.set(driver);
  }
}
