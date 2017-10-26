package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTest extends TestBase {
  FirefoxDriver wd;


  @Test
  public void testContactDeletion() {

    app.getNavigateHelper().gotoHomePage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactDate("Robert", "Honca", null,
              null, null, null, null));
    }
    app.getNavigateHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAcept();
    app.getNavigateHelper().gotoHomePage();
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }


}
