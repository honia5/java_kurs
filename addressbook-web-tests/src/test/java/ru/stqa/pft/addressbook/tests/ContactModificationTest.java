package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

/**
 * Created by honcaro on 2017-09-19.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigateHelper().gotoHomePage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactDate("Robert", "Honca", null,
              null, null, null, null));
    }
    app.getNavigateHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    ContactDate contact = new ContactDate(before.get(before.size() - 1).getId(),"Robert", "Honca", null,
            null, null, null, null);
    app.getContactHelper().fillNewContactForm(contact,false);
    app.getContactHelper().submitCraetionContact();
    app.getNavigateHelper().gotoHomePage();
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactDate> byId = (c1, c2)-> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
