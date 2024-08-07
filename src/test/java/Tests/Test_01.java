package Tests;

import Basecomponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;

public class Test_01 extends BaseTest
{
    LandingPage lp;
    CartPage cp;
    CheckoutPage chp;
    PaymentPage pp;

    String username = "jnanasr@gmail.com";
    String password = "Krishna1992@";
    String productName="IPHONE 13 PRO";

    String countryName="India";
    String finalSucMsg ="THANKYOU FOR THE ORDER.";
    String confirmationMsg="";

      @Test(priority = 1,description = "Login into the Application")
      public void Test1() throws InterruptedException
      {
          lp = new LandingPage(driver);
          lp.loginApplication(username,password);
      }

      @Test(priority = 2,description = "Select the Item and Add it into the cart and navigate to cartpage")
      public void Test2() throws InterruptedException
      {
          cp = new CartPage(driver);
          cp.selectProduct(productName);
          cp.clickCartPage();
      }

      @Test(priority = 3,description = "Navigate  to CartPage and Checkout")
      public void Test3() throws InterruptedException
      {
        chp = new CheckoutPage(driver);
        chp.checkProduct(productName);
      }

    @Test(priority = 4,description = "Navigate  to CartPage and Checkout")
    public void Test4() throws InterruptedException
    {
        pp = new PaymentPage(driver);
        pp.selectCountry(countryName);
        confirmationMsg = pp.validateConfirmationMsg();
        Assert.assertEquals(confirmationMsg,finalSucMsg);
    }

}
