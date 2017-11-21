package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreatingNew extends TestBase{


    @Test
    public void testCreatingNewContact() {

        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactDate contact = new ContactDate().withFirrstname("Robert").withLastname("Honca");
        app.contact().createContact(contact);
        app.goTo().contactPage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
    }


}
