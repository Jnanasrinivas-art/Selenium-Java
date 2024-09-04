package Tests;

import Basecomponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;

import java.io.IOException;

public class Test_02 extends BaseTest
{
    LandingPage lp;
    CartPage cp;

    String finalSucMsg ="THANKYOU FOR THE ORDER.";
    String productName="IPHONE 13 PRO";
    String countryName="India";

    String confirmationMsg="";
    CheckoutPage chp;
    PaymentPage pp;

    String username = "jnanasr@gmail.com";
    String password = "Krishna1992@";

    @Test(priority = 1,description = "Login into the Application")
    public void Test1() throws InterruptedException, IOException {
        lp = new LandingPage(driver);
        lp.loginApplication(username,password);
        cp = new CartPage(driver);
        cp.selectProduct(productName);
        cp.clickCartPage();
        Thread.sleep(2400);
        chp= new CheckoutPage(driver);
        chp.checkProduct(productName);
        pp = new PaymentPage(driver);
        pp.selectCountry(countryName);
        confirmationMsg = pp.validateConfirmationMsg();
        Assert.assertEquals(confirmationMsg,finalSucMsg);
    }

}
