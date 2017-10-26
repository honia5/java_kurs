package ru.stqa.pft.addressbook.model;

public class ContactDate {
  private int id;
  private final String firrstname;
  private final String lastname;
  private final String address;
  private final String mobile;
  private final String email;
  private final String home;
  private String group;

  public ContactDate(String firrstname, String lastname, String address,
                     String mobile, String email, String home, String group) {
    this.id = Integer.MAX_VALUE;
    this.firrstname = firrstname;
    this.lastname = lastname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.home = home;
    this.group = group;
  }

  public ContactDate(int id, String firrstname, String lastname, String address,
                     String mobile, String email, String home, String group) {
    this.id = id;
    this.firrstname = firrstname;
    this.lastname = lastname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.home = home;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDate that = (ContactDate) o;

    if (firrstname != null ? !firrstname.equals(that.firrstname) : that.firrstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = firrstname != null ? firrstname.hashCode() : 0;
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
