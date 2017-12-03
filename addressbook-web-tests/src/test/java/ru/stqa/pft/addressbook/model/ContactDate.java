package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactDate {


  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private String firrstname;
  @Expose
  @Column(name = "lastname")
  private String lastname;
  @Type(type = "text")
  private String photo;
  @Expose
  @Transient
  private String address;
  @Transient
  private String mobile;
  @Expose
  @Transient
  private String email;
  @Transient
  private String email2;
  @Transient
  private String email3;
  @Expose
  @Transient
  private String home;
  @Transient
  private String group;
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Transient
  private String allPhones;
  @Transient
  private String allEmails;
  @Transient
  private String allDeteils;


  public File getPhoto() {
    return new File(photo);
  }

  public ContactDate withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }


  public String getAllDeteils() {
    return allDeteils;
  }

  public ContactDate withAllDeteils(String allDeteils) {
    this.allDeteils = allDeteils;
    return this;
  }



  public String getAllEmails() {
    return allEmails;
  }

  public ContactDate withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public String getAllPhones() {
    return allPhones;
  }

  public ContactDate withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public int getId() {
    return id;
  }

  public ContactDate withId(int id) {
    this.id = id;
    return this;
  }

  public ContactDate withFirrstname(String firrstname) {
    this.firrstname = firrstname;
    return this;
  }

  public ContactDate withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactDate withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactDate withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactDate withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactDate withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactDate withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactDate withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactDate withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactDate withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactDate withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactDate withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }


  public String getFirrstname() {
    return firrstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getHome() {
    return home;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getGroup() {
    return group;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDate that = (ContactDate) o;

    if (id != that.id) return false;
    if (firrstname != null ? !firrstname.equals(that.firrstname) : that.firrstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firrstname != null ? firrstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
  @Override
  public String toString() {
    return "ContactDate{" +
            "id=" + id +
            ", firrstname='" + firrstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


}
