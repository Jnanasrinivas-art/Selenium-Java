package Abstractcomponents;

import excelData.DataDriven;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class Abstractcomponent
{
   public WebDriver driver;

   String Username;
   String Password;

    public Abstractcomponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='email@example.com']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='userPassword']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    public WebElement login;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    public WebElement CartPage;

    @FindBy(xpath = "//h1[@class='hero-primary']")
    public WebElement SucMsg;

    public void loginApplication(String pSheet,int pRow) throws InterruptedException, IOException {
        Username= DataDriven.readFromExcel(pSheet,"B",pRow);
        Password=DataDriven.readFromExcel(pSheet,"C",pRow);
        enterValues(username,Username);
        enterValues(password,Password);
        clickElement(login);
        Thread.sleep(3000);
    }

    public void clickElement(WebElement pElement)
    {
        if(pElement.isDisplayed())
        {
            pElement.click();
        }
        else
        {
            System.out.println("Element not displayed to click"+pElement.getText());
        }
    }

    public void clickElementBy(By pElement)
    {
        driver.findElement(pElement).click();

    }

    public void enterValues(WebElement pElement,String value)
    {
        if (pElement.isDisplayed())
        {
            pElement.sendKeys(value);
        }
        else
        {
            System.out.println("Element not displayed to click"+pElement.getText());
        }
    }

    public void waitForElementToAppear(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickCartPage() throws InterruptedException
    {
        Thread.sleep(3000);
        clickElement(CartPage);
    }

    public void selectOptionFromSuggestionDropdown(String value,List<WebElement> element) throws InterruptedException, IOException {
        for(WebElement eachElement : element)
        {
            String eachElementText = eachElement.getText();
            if(eachElementText.equalsIgnoreCase(value))
            {
                System.out.println(eachElementText);
                clickElement(eachElement);
                break;
            }
        }
    }

    public void scrollTillElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void randomNumGeneration(WebElement element)
    {
        Random random = new Random();
        int number=random.nextInt();
        String str = String.valueOf(number);
        int number1=random.nextInt(6);
        int number4=random.nextInt(1,10);
        String str1= String.valueOf(number1);
        String str2= String.valueOf(number4);
        System.out.println("Generated number "+number);
        System.out.println("Generated number "+number1);
        System.out.println("Generated number "+number4);
        element.sendKeys(str);
    }
    
}
