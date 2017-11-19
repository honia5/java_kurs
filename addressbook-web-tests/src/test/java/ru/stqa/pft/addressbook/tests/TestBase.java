package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmenager.ApplicationMenager;



/**
 * Created by HoncaRo on 2017-08-28.
 */
public class TestBase {

  protected static final ApplicationMenager app = new ApplicationMenager(BrowserType.FIREFOX);


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite
  public void tearDown() {
    app.stop();
  }


}
