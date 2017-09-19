package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by HoncaRo on 2017-09-17.
 */
public class SessionHelper extends HelperBase {


  public SessionHelper(FirefoxDriver wd) {

    super(wd);
  }
  public void login(String uesername, String password) {
    type(By.name("user"), uesername);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }

}
