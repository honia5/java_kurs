package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by honcaro on 2017-09-19.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactDate().withFirrstname("Robert").withLastname("Honca"));
    }

  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactDate modifedContact = before.iterator().next();
    ContactDate contact = new ContactDate()
            .withId(modifedContact.getId()).withFirrstname("Robert").withLastname("Honca");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifedContact).withAdded(contact)));

  }


}
