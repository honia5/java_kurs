package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by HoncaRo on 2017-11-22.
 */
public class ContactPhoneTest extends TestBase {

  @Test
  public void testContactPhone(){
    app.goTo().contactPage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditForm = app.contact().getInfoFromEditform(contact);

    assertThat(contact.getHomePhone(), equalTo(clened(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(clened(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(clened(contactInfoFromEditForm.getWorkPhone())));

  }

  public String clened(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");

  }




}
