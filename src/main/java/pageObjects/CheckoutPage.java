package pageObjects;

import Abstractcomponents.Abstractcomponent;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends Abstractcomponent
{
    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='cartSection']")
    List<WebElement> Items;

    By itemText = By.tagName("h3");

    @FindBy(xpath="//button[text()='Checkout']")
    WebElement checkout;

    public void checkProduct(String productName) throws InterruptedException {
       for(WebElement eachItem : Items)
       {
           String productText = eachItem.getText();
           if(productText.equalsIgnoreCase(productName))
           {
               System.out.println("The Item "+productText+"is available");
           }
       }
       checkout.click();
       Thread.sleep(3000);
    }
}
