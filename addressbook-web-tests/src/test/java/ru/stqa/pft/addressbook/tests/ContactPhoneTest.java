package ru.stqa.pft.addressbook.tests;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
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
public class ContactPhoneTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactDate().withFirrstname("Robert").withLastname("Honca"));
    }
  }

  @Test
  public void testContactPhone() {
    app.goTo().contactPage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditForm = app.contact().getInfoFromEditform(contact);

    assertThat(contact.getAddress(), equalTo(cleanedAddress(contactInfoFromEditForm.getAddress())));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }

  private String mergeEmails(ContactDate contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> s != null && !s.equals(""))
            .map(ContactPhoneTest::cleanedEmails)
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactDate contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTest::cleanedPhones)
            .collect(Collectors.joining("\n"));
  }

  private static String cleanedAddress(String address) {
    return address.replaceAll("\\\\r|\\\\n", "");
  }

  public static String cleanedPhones(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }

  private static String cleanedEmails(String email) {
    return email.replaceAll("\\s", "");
  }


}
