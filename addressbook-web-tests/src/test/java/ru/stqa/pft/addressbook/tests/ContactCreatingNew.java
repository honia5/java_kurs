package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactCreatingNew extends TestBase{


    @Test
    public void testCreatingNewContact() {

        app.goTo().contactPage();
        List<ContactDate> before = app.contact().list();
        ContactDate contact = new ContactDate("Robert", "Honca", null,
                null, null, null, null);
        app.contact().createContact(contact);
        app.goTo().contactPage();
        List<ContactDate> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);


        before.add(contact);
        Comparator<? super ContactDate> byId = Comparator.comparingInt(ContactDate::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
