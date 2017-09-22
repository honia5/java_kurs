package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by honcaro on 2017-09-19.
 */
public class GroupContact extends HelperBase {


  public GroupContact(WebDriver wd) {
    super(wd);
  }

  public void submitCraetionContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContactForm(ContactDate contactDate, boolean creation) {
    type(By.name("firstname"), contactDate.getFirrstname());
    type(By.name("lastname"), contactDate.getLastname());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("home"), contactDate.getHome());
    type(By.name("mobile"), contactDate.getMobile());
    type(By.name("email"), contactDate.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
    } else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
  }

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

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }
}
