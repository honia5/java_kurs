package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupCreationTest extends TestBase {

  @Test
  public void GroupCreationTest() {
    app.getNavigateHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCration();
    app.getGroupHelper().fillGroupForm(new GroupDate("test1", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
