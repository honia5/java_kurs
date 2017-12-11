package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by HoncaRo on 2017-12-11.
 */
public class RegistrationTest extends TestBase{

  @Test
  public void testRegistration(){
    app.registration().start("user1", "user1@localhost.localdomain");

  }
}
