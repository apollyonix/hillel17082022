package ua.hillel.ui.utils;

import org.openqa.selenium.WebDriver;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public class DriverHolder {
  private static DriverHolder holder;
  private WebDriver driver;

  private DriverHolder() {}

  public static DriverHolder getHolder() {
    if (holder==null) {
      holder = new DriverHolder();
    }
    return holder;
  }

  public static void setDriver(WebDriver driver) {
    getHolder().driver = driver;
  }

  public static WebDriver getDriver() {
    return getHolder().driver;
  }
}
