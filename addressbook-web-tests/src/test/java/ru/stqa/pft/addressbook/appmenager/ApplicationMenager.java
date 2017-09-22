package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by honcaro on 2017-09-14.
 */
public class ApplicationMenager {
  WebDriver wd;

  private GroupContact groupContact;
  private SessionHelper sessionHelper;
  private NavigateHelper navigateHelper;
  private GroupHelper groupHelper;
  private String browser;

  public ApplicationMenager(String browser) {
    this.browser = browser;
  }


  public void init() {
    if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }else if (browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
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
