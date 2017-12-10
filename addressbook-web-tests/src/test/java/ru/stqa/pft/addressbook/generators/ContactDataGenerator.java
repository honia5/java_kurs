package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactDate;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HoncaRo on 2017-11-29.
 */


public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch (ParameterException ex){
      jCommander.usage();
      return;
    }

    generator.run();

  }

  private void run() throws IOException {
    List<ContactDate> contacts = generateContacts(count);
    if (format.equals("csv")){
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    }else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJson(List<ContactDate> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactDate> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactDate.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(xml);
    }
  }

  //save file
  private void saveAsCsv(List<ContactDate> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try (Writer writer = new FileWriter(file)){
      for(ContactDate contact : contacts){
        writer.write(String.format("%s;%s;\n", contact.getFirrstname(), contact.getLastname(),contact.getAddress()
                ,contact.getEmail(), contact.getHome()));
      }
    }
  }
  //genereate file
  private List<ContactDate> generateContacts(int count) {
    List<ContactDate> contacts = new ArrayList<ContactDate>();
    for(int i = 0; i < count; i++){
      contacts.add(new ContactDate().withFirrstname(String.format("Robert\n%s", 1))
              .withLastname(String.format("Honca\n%s", 1))
              .withHome(String.format("5018448248\n%s", 1))
              .withEmail(String.format("test@gmail.com\n%s", 1))
              .withAddress(String.format("ul.Pilna 28, 44-155 Maciuwaksze\n%s", 1)));
    }
    return contacts;
  }


}
