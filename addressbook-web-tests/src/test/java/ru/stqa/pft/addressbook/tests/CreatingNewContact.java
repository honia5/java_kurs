package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class CreatingNewContact extends TestBase{


    @Test
    public void testCreatingNewContact() {
        app.getGroupContact().gotoAddNewContactPage();
        app.getGroupContact().fillNewContactForm(new ContactDate("Robert", "Honca", "testAddress",
                "502847569", "robert.honca@gmail.com", "332145779"));
        app.getGroupContact().submitCraetionContact();
        app.getNavigateHelper().gotoHomePage();
    }


}
