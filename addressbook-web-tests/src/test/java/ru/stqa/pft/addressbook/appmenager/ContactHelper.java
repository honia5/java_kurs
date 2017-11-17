package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.ArrayList;
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

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void alertAcept() {
    wd.switchTo().alert().accept();

  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification(int index) {

    wd.findElements(By.xpath("//tr[@name='entry']//td[@class='center'][3]")).get(index).click();
  }

  public void createContact(ContactDate contact) {
    gotoAddNewContactPage();
    fillNewContactForm(contact, true);
    submitCraetionContact();


  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//tr[@name='entry']"));
  }

  public List<ContactDate> getContactList() {
    List<ContactDate> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firrstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      //String firrstname = element.findElement(By.xpath(".//td[2]")).getText();
      //String lastname = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactDate contact = new ContactDate(id, firrstname, lastname, null,
              null, null, null, null);
      contacts.add(contact);

    }
    return contacts;
  }

}
