package ua.hillel.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.ui.pages.SecurePage;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public class LoginTest extends BaseTest {
  @Test
  public void loginTest() {
    SecurePage securePage = openApp().goToAuthPage()
        .setUsername("tomsmith")
        .setPassword("SuperSecretPassword!")
        .clickLoginButton();
    String alert = securePage.getAlertText();

    Assert.assertTrue(alert.contains("You logged into a secure area!"),
                      "User should be logged in");

    securePage.logout();
  }
}
