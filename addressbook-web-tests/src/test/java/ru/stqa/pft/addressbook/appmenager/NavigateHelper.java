package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by HoncaRo on 2017-09-17.
 */
public class NavigateHelper extends HelperBase {


  public NavigateHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
      && wd.findElement(By.tagName("h1")).getText().equals("Groups")
      && isElementPresent(By.name("new"))){
    return;
    }
    click(By.linkText("groups"));
  }
  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }

}
