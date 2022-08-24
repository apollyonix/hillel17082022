package ua.hillel.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public class SecurePage extends BasePage {
  private final By byLogoutButton = By.cssSelector("a.button");

  @FindBy(css = "a.button")
  private WebElement logoutButton;

  @FindBy(tagName = "h2")
  private WebElement pageTitle;

  @FindBy(css = ".flash.success")
  private WebElement alert;

  public SecurePage() {
    super();
    PageFactory.initElements(driver, this);
  }

  public LoginPage logout() {
    logoutButton.click();
    return new LoginPage();
  }

  public String getPageTitle() {
    return pageTitle.getText();
  }

  public String getAlertText() {
    return alert.getText();
  }
}
