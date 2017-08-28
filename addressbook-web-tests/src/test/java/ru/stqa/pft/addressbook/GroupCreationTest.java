package ru.stqa.pft.addressbook;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void GroupCreationTest() {
    gotoGroupPage();
    initGroupCration();
    fillGroupForm(new GroupDate("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
