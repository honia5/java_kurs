package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by HoncaRo on 2017-11-22.
 */
public class ContactEditDeteilsTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactDate().withFirrstname("Robert").withLastname("Honca"));
    }
  }

  @Test (enabled = false)
  public void testContactPhone() {
    app.goTo().contactPage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditForm = app.contact().getInfoFromEditform(contact);

    assertThat(contact.getAddress(), equalTo(cleanedAddress(contactInfoFromEditForm.getAddress())));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }
  @Test
  public void testContactDeteils() {
    app.goTo().contactPage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactDateFromDeteilsForm = app.contact().getInfoFromDeteilsForm(contact);
    ContactDate contactInfoFromEditForm = convertContactToEqualsViewFormat(app.contact().getInfoFromEditform(contact));
    assertThat(contactDateFromDeteilsForm.getAllDeteils(), equalTo(mergeDateDeteils(contactInfoFromEditForm)));




  }
  private String mergeDateDeteils(ContactDate contact) {
    return Arrays.asList(contact.getFirrstname(), contact.getLastname(), contact.getAddress(),
            contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
            contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            //.map(ContactEditDeteilsTest::cleanedDeteils)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactDate contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> s != null && !s.equals(""))
            .map(ContactEditDeteilsTest::cleanedEmails)
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactDate contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactEditDeteilsTest::cleanedPhones)
            .collect(Collectors.joining("\n"));
  }

  private static String cleanedAddress(String address) {
    return address.replaceAll("(\\\\r|\\\\n)+", "");
  }

  public static String cleanedPhones(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }

  private static String cleanedEmails(String email) {
    return email.replaceAll("\\s", "");
  }

  private static String cleanedDeteils(String deteil) {
    return deteil.replaceAll("\\n", "");
  }

  public static ContactDate convertContactToEqualsViewFormat(ContactDate contact) {
    String firsname = contact.getFirrstname();
    String lastname = contact.getLastname();
    String home = contact.getHomePhone();
    String mobile = contact.getMobilePhone();
    String work = contact.getWorkPhone();
    String address = contact.getAddress();

    if (!firsname.equals(firsname)) {
      firsname += "\\n";
    }
    if (!lastname.equals("")) {
      lastname += "\\n";
    }

    if (!address.equals("")) {
      address += "\\n";
    }

    if (!home.equals("")) {
      home = "H: " + home;
    }

    if (!mobile.equals("")) {
      mobile = "M: " + mobile;
    }
    if (!work.equals("")) {
      work = "W: " + work + "\n";
    }

    return contact.withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address);
  }



}
