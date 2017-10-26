package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactCreatingNew extends TestBase{


    @Test
    public void testCreatingNewContact() {

        app.getNavigateHelper().gotoHomePage();
        List<ContactDate> before = app.getContactHelper().getContactList();
        ContactDate contact = new ContactDate("Robert", "Honca", null,
                null, null, null, null);
        app.getContactHelper().createContact(contact);
        app.getNavigateHelper().gotoHomePage();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);


        before.add(contact);
        Comparator<? super ContactDate> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
