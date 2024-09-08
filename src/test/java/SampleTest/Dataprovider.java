package SampleTest;

import Basecomponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;

// Using data Provider, need to change to @BeforeMethod and @AfterMethod in Baseclass to run with multiple data sets

public class Dataprovider extends BaseTest {
    LandingPage lp;
    CartPage cp;
    String finalSucMsg = "THANKYOU FOR THE ORDER.";
    String countryName = "India";
    String confirmationMsg = "";
    CheckoutPage chp;
    PaymentPage pp;

    @Test(description = "Cart process", dataProvider = "loginData")
    public void Process(String Username, String Password,String productName) throws InterruptedException {
        lp = new LandingPage(driver);
        //lp.loginApplication(Username, Password);
        cp = new CartPage(driver);
        //cp.selectProduct(productName);
        cp.clickCartPage();
        Thread.sleep(3000);
        chp = new CheckoutPage(driver);
        //chp.checkProduct(productName);
        pp = new PaymentPage(driver);
        //pp.selectCountry(countryName);
        confirmationMsg = pp.validateConfirmationMsg();
        Assert.assertEquals(confirmationMsg, finalSucMsg);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        Object[][] obj = new Object[2][3];
        obj[0][0] = "jnanasr@gmail.com";
        obj[0][1] = "Krishna1992@";
        obj[0][2] = "IPHONE 13 PRO";

        obj[1][0] = "shetty@gmail.com";
        obj[1][1] = "Iamking@000";
        obj[1][2] = "IPHONE 13 PRO";
        return obj;
    }
}