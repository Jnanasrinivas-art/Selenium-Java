package Tests;

import Basecomponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;

// Using data Provider
public class Dataprovider extends BaseTest
{
        LandingPage lp;
        CartPage cp;
        String finalSucMsg ="THANKYOU FOR THE ORDER.";
        String productName="IPHONE 13 PRO";
        String countryName="India";
        String confirmationMsg="";
        CheckoutPage chp;
        PaymentPage pp;

        @Test(description = "Cart process",dataProvider = "loginData")
        public void Process(String username,String password) throws InterruptedException {
            lp = new LandingPage(driver);
            lp.loginApplication(username,password);
            cp = new CartPage(driver);
            cp.selectProduct(productName);
            cp.clickCartPage();
            Thread.sleep(7000);
            chp= new CheckoutPage(driver);
            chp.checkProduct(productName);
            pp = new PaymentPage(driver);
            pp.selectCountry(countryName);
            confirmationMsg = pp.validateConfirmationMsg();
            Assert.assertEquals(confirmationMsg,finalSucMsg);
        }

        @DataProvider(name = "loginData")
        public Object[][] getData()
        {
            Object[][] obj = new Object[2][2];
            obj[0][0]="jnanasr@gmail.com";
            obj[0][1]="Krishna1992@";

            obj[1][0]="anshika@gmail.com";
            obj[1][1]="Krisna1990@";
            return obj;
        }
}