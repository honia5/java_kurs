package ru.stqa.pft.mantis.appmenager;

import org.openqa.selenium.WebDriver;

/**
 * Created by HoncaRo on 2017-12-11.
 */
public class RegistrationHelper {
  private final ApplicationMenager app;
  private WebDriver wd;

  public RegistrationHelper(ApplicationMenager app) {
    this.app = app;
    wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "signup_page.php");
  }
}
