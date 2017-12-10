package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmenager.ApplicationMenager;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by HoncaRo on 2017-08-28.
 */
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

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

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("Start Test" + m.getName() + "with parameters" + Arrays.asList(p));

  }
  @AfterMethod (alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop Test" + m.getName());
  }

  private void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")){
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupDate().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }

  }
}
