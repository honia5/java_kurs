package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupCreationTest extends TestBase {

  @Test
  public void GroupCreationTest() {
    app.getNavigateHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupDate("test1", null, null));
  }

}
