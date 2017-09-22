package ru.stqa.pft.addressbook.model;

public class ContactDate {
  private final String firrstname;
  private final String lastname;
  private final String address;
  private final String mobile;
  private final String email;
  private final String home;
  private String group;

  public ContactDate(String firrstname, String lastname, String address,
                     String mobile, String email, String home, String group) {
    this.firrstname = firrstname;
    this.lastname = lastname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.home = home;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}
