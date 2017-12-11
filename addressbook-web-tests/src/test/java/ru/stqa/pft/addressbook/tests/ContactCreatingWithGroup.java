package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by HoncaRo on 2017-12-10.
 */
public class ContactCreatingWithGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0){
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        Groups before = app.db().groups();
        GroupDate group = new GroupDate().withName("TestGroup1");
        app.group().create(group);
        assertThat(app.db().groups().size(), equalTo(before.size() + 1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream()
                .mapToInt(g -> g.getId()).max().getAsInt()))));
      }
      app.goTo().contactPage();
      Contacts before = app.db().contacts();
      ContactDate contact = new ContactDate()
              .withFirrstname("Robert2").withLastname("Honca2").withAddress("ul.Pilna 28, 44-155 Maciuwaksze")
              .withHome("50184482481").withEmail("test@gmail.com");
      app.contact().createContact(contact);
      app.goTo().contactPage();
      assertThat(app.db().contacts().size(), equalTo(before.size()+1));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
    }
  }

  @Test
  public void testContactWithGroupCreating(){
    Contacts contactsAtAll = app.db().contacts();
    ContactDate contact = contactsAtAll.iterator().next();
    Groups groupsInContacts = contact.getGroups();
    Groups groupsAtAll = app.db().groups();
    GroupDate assosiateGroup;
    if (groupsInContacts.size() == groupsAtAll.size()){
      app.goTo().groupPage();
      app.group().create(new GroupDate().withName("AssosiateGroupName"));
      Groups groupsAddNew = app.db().groups();
      groupsAddNew.remove(groupsAtAll);
      assosiateGroup = groupsAddNew.iterator().next();
    }else {
      groupsAtAll.removeAll(groupsInContacts);
      assosiateGroup = groupsAtAll.iterator().next();
    }
    app.goTo().contactPage();
    app.contact().addContactToGroup(contact, assosiateGroup);
    app.goTo().contactPage();
    assertThat(app.db().contacts(contact.getId()).getGroups(), equalTo(groupsInContacts.withAdded(assosiateGroup)));


  }
}
