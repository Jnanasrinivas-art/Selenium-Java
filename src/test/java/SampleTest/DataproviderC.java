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

public class DataproviderC extends BaseTest
{
    LandingPage lp;
    CartPage cp;
    String finalSucMsg ="THANKYOU FOR THE ORDER.";
    String countryName="India";
    String confirmationMsg="";
    CheckoutPage chp;
    PaymentPage pp;

    @Test(description = "Cart process",dataProvider = "getData")
    public void Process(String username,String password,String productName) throws InterruptedException {
        lp = new LandingPage(driver);
        //lp.loginApplication(username,password);
        cp = new CartPage(driver);
        //cp.selectProduct(productName);
        cp.clickCartPage();
        Thread.sleep(7000);
        chp= new CheckoutPage(driver);
        //chp.checkProduct(productName);
        pp = new PaymentPage(driver);
        //pp.selectCountry(countryName);
        confirmationMsg = pp.validateConfirmationMsg();
        Assert.assertEquals(confirmationMsg,finalSucMsg);
        Thread.sleep(3000);
    }

    @DataProvider
    public Object[][] getData()
    {
       return new Object[][]
               {
                       {"jnanasr@gmail.com","Krishna1992@","IPHONE 13 PRO"},
                       {"anshika@gmail.com","Iamking@000","IPHONE 13 PRO"}
               };
    }

}
