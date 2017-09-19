package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by honcaro on 2017-09-19.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification (){
    app.getNavigateHelper().gotoHomePage();
    app.getGroupContact().initContactModification();
    app.getGroupContact().fillNewContactForm(new ContactDate("Robert", "Honca", "testAddress",
            "502847569", "robert.honca@gmail.com", "332145779"));
    app.getGroupContact().submitCraetionContact();
    app.getNavigateHelper().gotoHomePage();

  }



}
