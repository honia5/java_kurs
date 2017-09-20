package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmenager.ApplicationMenager;
import sun.plugin2.util.BrowserType;

/**
 * Created by HoncaRo on 2017-08-28.
 */
public class TestBase {

  protected final ApplicationMenager app = new ApplicationMenager(org.openqa.selenium.remote.BrowserType.FIREFOX);
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }


  @AfterMethod
  public void tearDown() {
    app.stop();
  }


}
