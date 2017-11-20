package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Set;

/**
 * Created by honcaro on 2017-09-19.
 */
public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupDate().withName("test1"));
    }
  }

  @Test
  public void testGroupModification (){
    Set<GroupDate> before = app.group().all();
    GroupDate modifedGroup = before.iterator().next();
    GroupDate group = new GroupDate()
            .withId(modifedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Set<GroupDate> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifedGroup);
    before.add(group);
    Assert.assertEquals(before, after);




  }


}
