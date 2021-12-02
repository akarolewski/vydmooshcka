package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

class DriverSetup {

  static WebDriver localChrome() {
    ChromeOptions options = new ChromeOptions();
    System.setProperty("webdriver.chrome.silentOutput", "true");

    chromedriver().setup();
    if (System.getProperty("runHeadless") != null) {
      options.setHeadless(true);
    }
    return new ChromeDriver(options);
  }
}
