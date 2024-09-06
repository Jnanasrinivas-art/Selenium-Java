package Tests;

import Abstractcomponents.Abstractcomponent;
import Basecomponent.BaseTest;
import excelData.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;

import java.io.IOException;

public class Test_02 extends BaseTest
{
    String finalSucMsg ="THANKYOU FOR THE ORDER.";
    String confirmationMsg="";

    @Test(priority = 1,description = "Login into the Application")
    public void Test2() throws InterruptedException, IOException
    {
        abstrct_comp.loginApplication();
        cart_page.selectProduct();
        cart_page.clickCartPage();
        checkout_page.checkProduct();
        payment_page.selectCountry();
        confirmationMsg = payment_page.validateConfirmationMsg();
        Assert.assertEquals(confirmationMsg,finalSucMsg);
    }

}