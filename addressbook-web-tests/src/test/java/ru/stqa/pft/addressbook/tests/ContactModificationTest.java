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
    if (app.db().contacts().size() == 0) {
      app.contact().createContact(new ContactDate().withFirrstname("Robert").withLastname("Honca")
              .withAddress("ul.Pilna 28, 44-155 Maciuwaksze").withHome("50184482481").withEmail("test@gmail.com"));
    }

  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactDate modifedContact = before.iterator().next();
    ContactDate contact = new ContactDate()
            .withId(modifedContact.getId()).withFirrstname("Robert2").withLastname("Honca2")
            .withAddress("ul.Pilna 28, 44-155 Maciuwaksze").withHome("50184482481").withEmail("test@gmail.com");
    app.goTo().contactPage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifedContact).withAdded(contact)));


  }


}
