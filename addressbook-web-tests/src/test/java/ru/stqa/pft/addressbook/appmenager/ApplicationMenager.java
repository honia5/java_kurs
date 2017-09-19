package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by honcaro on 2017-09-14.
 */
public class ApplicationMenager {
  FirefoxDriver wd;

  private GroupContact groupContact;
  private SessionHelper sessionHelper;
  private NavigateHelper navigateHelper;
  private GroupHelper groupHelper;


  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/addressbook/");
    groupHelper = new GroupHelper(wd);
    groupContact = new GroupContact(wd);
    navigateHelper = new NavigateHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigateHelper getNavigateHelper() {
    return navigateHelper;
  }


  public GroupContact getGroupContact() {
    return groupContact;
  }
}
