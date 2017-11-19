package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

/**
 * Created by honcaro on 2017-09-19.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().list().size() == 0) {
      app.contact().createContact(new ContactDate("Robert", "Honca", null,
              null, null, null, null));
    }

  }

  @Test
  public void testContactModification() {
    List<ContactDate> before = app.contact().list();
    int index = before.size() - 1;
    ContactDate contact = new ContactDate(before.get(index).getId(), "Robert", "Honca", null,
            null, null, null, null);
    app.contact().modify(index, contact);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactDate> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
