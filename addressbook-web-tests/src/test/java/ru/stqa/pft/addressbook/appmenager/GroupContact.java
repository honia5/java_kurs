package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by honcaro on 2017-09-19.
 */
public class GroupContact extends HelperBase {


  public GroupContact(FirefoxDriver wd) {
    super(wd);
  }

  public void submitCraetionContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContactForm(ContactDate contactDate) {
    type(By.name("firstname"), contactDate.getFirrstname());
    type(By.name("lastname"), contactDate.getLastname());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("home"), contactDate.getHome());
    type(By.name("mobile"), contactDate.getMobile());
    type(By.name("email"), contactDate.getEmail());
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
}
