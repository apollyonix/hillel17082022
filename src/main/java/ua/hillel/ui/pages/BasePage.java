package ua.hillel.ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.hillel.ui.utils.DriverHolder;

import java.time.Duration;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public abstract class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Actions actions;
  protected JavascriptExecutor jsExecutor;

  public BasePage() {
    this.driver = DriverHolder.getDriver();
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.actions = new Actions(driver);
    this.jsExecutor = (JavascriptExecutor)driver;
  }
}
