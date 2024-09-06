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

public class CartPage extends Abstractcomponent
{
    String productName;

    public WebDriver driver;
    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='card']")
    public List<WebElement> products;

    By itemName = By.tagName("h5");
    By AddToCart = By.cssSelector("button:nth-of-type(2)");

    By productMsg = By.xpath("//div[contains(text(),'Product Added To Cart ')]");
    public void selectProduct() throws InterruptedException, IOException {
        productName= DataDriven.readFromExcel("testdata","D",3);
        for(WebElement product:products)
        {
            String productText = product.findElement(itemName).getText();
            if(productText.equalsIgnoreCase(productName))
            {
                System.out.println("Product Name is "+productName);
                product.findElement(AddToCart).click();
                Thread.sleep(2000);
            }
        }
        waitForElementToAppear(productMsg);
    }

}
