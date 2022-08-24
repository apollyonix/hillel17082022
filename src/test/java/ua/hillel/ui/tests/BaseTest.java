package ua.hillel.ui.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import ua.hillel.ui.pages.MainPage;
import ua.hillel.ui.utils.DriverHolder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public class BaseTest {

  @BeforeClass
  @Parameters({"browser"})
  public void setUp(String browser) {
    WebDriver driver = null;
    if ("chrome".equalsIgnoreCase(browser)) {
          WebDriverManager.chromedriver().setup();
          ChromeOptions options = new ChromeOptions();
          Map<String, Object> prefs = new HashMap<>();
          prefs.put("download.default_directory", new File("target/downloads").getAbsolutePath());
          options.setExperimentalOption("prefs", prefs);
          driver = new ChromeDriver(options);
    } else {
      ChromeOptions options = new ChromeOptions();
      options.setCapability("browserVersion", "103.0");
      options.setCapability("selenoid:options", new HashMap<String, Object>() {{
        /* How to add test badge */
        put("name", "Test badge...");
        /* How to set session timeout */
        put("sessionTimeout", "1m");
        /* How to set timezone */
        put("env", new ArrayList<String>() {{
          add("TZ=UTC");
        }});
        /* How to add "trash" button */
        put("labels", new HashMap<String, Object>() {{
          put("manual", "true");
        }});
        /* How to enable video recording */
        //      put("enableVideo", true);
        put("enableVNC", true);
      }});
      try {
        driver = new RemoteWebDriver(new URL("http://192.168.3.46:4444/wd/hub"), options);
      } catch (MalformedURLException e) {
      }
    }
    DriverHolder.setDriver(driver);
  }

  @AfterClass
  public void tearDown() {
    DriverHolder.getDriver().quit();
  }

  public MainPage openApp() {
    DriverHolder.getDriver().get("https://the-internet.herokuapp.com/");
    return new MainPage();
  }
}
