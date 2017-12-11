package ru.stqa.pft.addressbook.appmenager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

/**
 * Created by HoncaRo on 2017-12-03.
 */
public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(){
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupDate> result = session.createQuery( "from GroupDate" ).list();
    for (GroupDate groups : result) {
      System.out.println(groups);
    }
    session.getTransaction().commit();
    session.close();
    return new Groups(result);

  }
  public GroupDate groups(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    String request = "from GroupDate where group_id = " + id;
    System.out.println(request);
    List<GroupDate> resultGroup = session.createQuery(request).list();
    GroupDate result =  resultGroup.iterator().next();
    session.getTransaction().commit();
    session.close();
    return result;

  }
  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List <ContactDate> result = session.createQuery("from ContactDate where deprecated = '0000-00-00'").list();
    for (ContactDate contacts : result) {
      System.out.println(contacts);
    }
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);

  }
  public ContactDate contacts(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    String request = "from ContactDate where id = " + id;
    List<ContactDate> resultContact = session.createQuery(request).list();
    ContactDate result =  resultContact.iterator().next();
    session.getTransaction().commit();
    session.close();
    return result;
  }


}
