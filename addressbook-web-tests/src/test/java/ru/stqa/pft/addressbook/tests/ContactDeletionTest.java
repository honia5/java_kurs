package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactDeletionTest extends TestBase {
  FirefoxDriver wd;


  @Test
  public void testContactDeletion() {

    app.getNavigateHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactDate("Robert", "Honca", "testAddress",
              "502847569", "robert.honca@gmail.com", "332145779", "test1"));
    }
    app.getNavigateHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAcept();
  }


}
