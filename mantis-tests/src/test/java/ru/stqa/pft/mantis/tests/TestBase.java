package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmenager.ApplicationMenager;


/**
 * Created by HoncaRo on 2017-08-28.
 */
public class TestBase {


  protected static final ApplicationMenager app
          = new ApplicationMenager(System.getProperty("browser", BrowserType.FIREFOX));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite (alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


}
