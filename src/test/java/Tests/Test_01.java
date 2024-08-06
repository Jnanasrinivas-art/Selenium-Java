package Tests;

import Basecomponent.BaseTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

public class Test_01 extends BaseTest
{

    String username = "jnanasr@gmail.com";
    String password = "Krishna1992@";

      @Test
      public void Test1() throws InterruptedException
      {
          LandingPage lp = new LandingPage(driver);
          lp.loginApplication(username,password);
      }
}
