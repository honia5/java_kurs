package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

/**
 * Created by honcaro on 2017-12-02.
 */
public class HbConnectionTest {


  private SessionFactory sessionFactory;

  @BeforeMethod
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy( registry );
      return;
    }
  }

  @Test
  public void testHbConnectionGroups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupDate> result = session.createQuery("from GroupDate").list();
      for (GroupDate groups : result) {
        System.out.println(groups);
        System.out.println(groups.getContacts());
     }
    session.getTransaction().commit();
    session.close();
  }

  @Test
  public void testHbConnectionContacts(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactDate> result = session.createQuery( "from ContactDate where deprecated = '0000-00-00'" ).list();
    session.getTransaction().commit();
    session.close();
    for ( ContactDate contact : result ) {
      System.out.println(contact);
      System.out.println(contact.getGroups());
    }

  }
}
