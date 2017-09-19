package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
  FirefoxDriver wd;


  @Test
  public void testContactDeletion() {

    app.getNavigateHelper().gotoHomePage();
    app.getGroupContact().selectContact();
    app.getGroupContact().deleteContact();
    app.getGroupContact().alertAcept();
  }


}
