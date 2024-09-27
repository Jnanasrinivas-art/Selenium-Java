package Tests;

import Basecomponent.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Test_02 extends BaseTest
{
    String testData_Sheet = "Test-sheet";
    String finalSucMsg ="THANKYOU FOR THE ORDER.";
    String confirmationMsg="";

    @Test(priority = 1,description = "Login into the Application")
    public void Test2() throws InterruptedException, IOException {
        abstrct_comp.loginApplication(testData_Sheet, 3);
        cart_page.selectProduct(testData_Sheet, 3);
        cart_page.clickCartPage();
        checkout_page.checkProduct(testData_Sheet, 3);
        payment_page.selectCountry(testData_Sheet, 3);
        confirmationMsg = payment_page.validateConfirmationMsg();
        Assert.assertEquals(confirmationMsg, finalSucMsg);
    }

}
