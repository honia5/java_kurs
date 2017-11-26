package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by honcaro on 2017-09-19.
 */
public class ContactHelper extends HelperBase {



  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitCraetionContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContactForm(ContactDate contactDate, boolean creation) {
    type(By.name("firstname"), contactDate.getFirrstname());
    type(By.name("lastname"), contactDate.getLastname());
//    type(By.name("address"), contactDate.getAddress());
//    type(By.name("home"), contactDate.getHome());
//    type(By.name("mobile"), contactDate.getMobile());
//    type(By.name("email"), contactDate.getEmail());

//    if (creation) {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
//    } else{
//      Assert.assertFalse(isElementPresent(By.name("new_group")));
//  }

  }


  public void gotoAddNewContactPage() {
    click(By.linkText("add new"));

  }

  public void contactPage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void alertAcept() {
    wd.switchTo().alert().accept();

  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void initContactModification(int id) {

    click(By.xpath("//tr[@name='entry']//td[@class='center'][3]"));

  }



  public void createContact(ContactDate contact) {
    gotoAddNewContactPage();
    fillNewContactForm(contact, true);
    submitCraetionContact();
    contactCache = null;


  }

  public void modify(ContactDate contact) {
    contactPage();
    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    fillNewContactForm(contact, false);
    submitCraetionContact();
    contactCache = null;
    contactPage();
  }

  public void delete(ContactDate contact) {
    contactPage();
    selectContactById(contact.getId());
    deleteContact();
    alertAcept();
    contactCache = null;
    contactPage();
  }


  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//tr[@name='entry']"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;


  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firrstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactDate contact = new ContactDate().withId(id).withLastname(lastname).withFirrstname(firrstname)
              .withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails);
      contactCache.add(contact);

    }
    return new Contacts(contactCache);
  }

  public ContactDate getInfoFromEditform(ContactDate contact) {
    initContactModificationById(contact.getId());
    String firrstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactDate().withId(contact.getId()).withFirrstname(firrstname).withLastname(lastname)
            .withAddress(address).withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone)
            .withEmail(email).withEmail2(email2).withEmail3(email3);

  }
  public ContactDate getInfoFromDeteilsForm(ContactDate contact) {
    initContactDeteilsById(contact.getId());
    String allDetails = wd.findElement(By.xpath("//div[@id='content']")).getText();
    wd.navigate().back();
    return new ContactDate().withAllDeteils(allDetails);



  }
  public void initContactModificationById(int id) {

    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

  }
  public void initContactDeteilsById(int id) {

    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();

  }


}
