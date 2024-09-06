package pageObjects;

import Abstractcomponents.Abstractcomponent;
import excelData.DataDriven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class PaymentPage extends Abstractcomponent
{

    String countryName;

    public WebDriver driver;
    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    public WebElement country;

    @FindBy(css = ".ta-item")
    public List<WebElement> countries;

    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
    public WebElement placeOrder;

    @FindBy(xpath = "//h1[@class='hero-primary']")
    WebElement SucMsg;

    By dropdown = By.cssSelector(".ta-results");


    public void enterCountry() throws InterruptedException
    {
        country.sendKeys("Ind");
        waitForElementToAppear(dropdown);
    }

    public void selectCountry() throws InterruptedException, IOException {
        countryName= DataDriven.readFromExcel("testdata","E",3);
       enterCountry();
       for(WebElement eachCountry : countries)
       {
           String eachCountryText = eachCountry.getText();
           if(eachCountryText.equalsIgnoreCase(countryName))
           {
               System.out.println(eachCountryText);
               eachCountry.click();
               break;
           }
       }
       Thread.sleep(3000);
       scrollTillElement(placeOrder);
       Thread.sleep(2000);
       placeOrder.click();
       Thread.sleep(3000);
    }

    public String validateConfirmationMsg()  {
        return SucMsg.getText();
    }

}
