package Tests;

import Basecomponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_01 extends BaseTest
{
    String testData_Sheet = "Test-sheet";
    String finalSucMsg ="THANKYOU FOR THE ORDER.";
    String confirmationMsg;

      @Test(priority = 1,groups = {"smoke","regression"},description = "Login into the Application")
      public void Test1() throws InterruptedException, IOException
      {
          abstrct_comp.loginApplication(testData_Sheet,3);
      }

      @Test(priority = 2,groups = {"smoke","regression"},description = "Select the Item and Add it into the cart and navigate to cartpage")
      public void Test2() throws InterruptedException, IOException
      {
          cart_page.selectProduct(testData_Sheet,3);
          cart_page.clickCartPage();
          Thread.sleep(2400);
      }

    @Test(priority = 3,groups = "smoke",description = "Navigate  to CartPage and Checkout")
    public void Test3() throws InterruptedException, IOException
    {
        checkout_page.checkProduct(testData_Sheet,3);
    }

    @Test(priority = 4,description = "Navigate  to PaymentPage and placeorder")
    public void Test4() throws InterruptedException, IOException
    {
        payment_page.selectCountry(testData_Sheet,3);
        confirmationMsg = payment_page.validateConfirmationMsg();
        Assert.assertEquals(confirmationMsg,finalSucMsg);
    }

}


