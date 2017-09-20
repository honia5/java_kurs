package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by HoncaRo on 2017-09-17.
 */
public class NavigateHelper extends HelperBase {


  public NavigateHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
  public void gotoHomePage() {
    click(By.xpath("//*[@id='nav']/ul/li[1]/a"));
  }

}
