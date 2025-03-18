package bddStepDefinition;

import Basecomponent.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionImpl extends BaseTest
{

    String testData_Sheet = "Test-sheet";
    String finalSucMsg ="THANKYOU FOR THE ORDER.";
    String confirmationMsg;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws Exception
    {
        openBrowser();
    }

    @Given("Login with username and password")
    public void Login_with_username_and_password() throws IOException, InterruptedException
    {
        abstrct_comp.loginApplication(testData_Sheet,3);
    }

    @When("Order the item and Submit the Order")
    public void Order_the_item_and_Submit_the_Order() throws IOException, InterruptedException
    {
        cart_page.selectProduct(testData_Sheet,3);
        cart_page.clickCartPage();
        Thread.sleep(2400);
        checkout_page.checkProduct(testData_Sheet,3);
    }

    @And("do the payment")
    public void do_the_payment() throws IOException, InterruptedException {
        payment_page.selectCountry(testData_Sheet,3);
    }

    @Then("{string} message is displayed on Confirmation Page")
    public void message_is_displayed_on_Confirmation_Page(String string)
    {
        confirmationMsg = payment_page.validateConfirmationMsg();
        Assert.assertEquals(confirmationMsg,string);
        driver.close();
    }
}
