package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreatingNew extends TestBase{


    @Test
    public void testCreatingNewContact() {
        app.getContactHelper().createContact(new ContactDate("Robert", "Honca", "testAddress",
                "502847569", "robert.honca@gmail.com", "332145779", "test1"));
        app.getNavigateHelper().gotoHomePage();
    }


}
