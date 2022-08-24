package ua.hillel.ui.pages;

import org.openqa.selenium.By;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public class MainPage extends BasePage {

  public MainPage() {
     super();
  }

  public LoginPage goToAuthPage() {
    driver.findElement(By.linkText("Form Authentication")).click();
    return new LoginPage();
  }

}
