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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class Abstractcomponent
{
   public WebDriver driver;

   public WebDriverWait wait;
    String expLogMsg="Login Successfully";

    public Abstractcomponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='email@example.com']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='userPassword']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    public WebElement login;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    public WebElement CartPage;

    @FindBy(xpath = "//h1[@class='hero-primary']")
    public WebElement SucMsg;

    @FindBy(xpath = "//div[text()=' Login Successfully ']")
    public WebElement logsucmsg;

    public void loginApplication(String pSheet,int pRow) throws InterruptedException, IOException {
       String Username= DataDriven.readFromExcel(pSheet,"B",pRow);
       String Password=DataDriven.readFromExcel(pSheet,"C",pRow);
        enterValues(username,Username);
        enterValues(password,Password);
        clickElement(login);
        String actualLogMsg = validateMsg(logsucmsg);
        Assert.assertEquals(actualLogMsg,expLogMsg);
    }

    public void clickElement(WebElement pElement)
    {
        try {
            if (pElement.isDisplayed())
            {
                pElement.click();
            }
            else {
                System.out.println("Element not displayed to click" + pElement.getText());
            }
        }
        catch (Exception e)
        {
            System.out.println("An exception occurred while trying to click  " + e.getMessage());
        }
    }

    public void clickElement(By byElement)
    {
        try {
            WebElement element = driver.findElement(byElement);
            if (element.isDisplayed())
            {
                element.click();
            }
            else {
                System.out.println("Element not displayed to click" + element.getText());
            }
        }
        catch (Exception e)
        {
            System.out.println("An exception occurred while trying to click " + e.getMessage());
        }
    }

    public void clickElements(By byElement) {
        List<WebElement> elements = driver.findElements(byElement);

        if (elements.isEmpty())
        {
            System.out.println("No elements found to click.");
        }
        else
        {
            for (WebElement element : elements) {
                if (element.isDisplayed())
                {
                    element.click();
                }
                else
                {
                    System.out.println("Element not displayed: " + element.getText());
                }
            }
        }
    }

    public void enterValues(WebElement pElement,String value)
    {
        try {
            if (pElement.isDisplayed()) {
                pElement.sendKeys(value);
            } else {
                System.out.println("Element not displayed to click" + pElement.getText());
            }
        }
        catch (Exception e)
        {
            System.out.println("An exception occurred while trying to send keys: " + e.getMessage());
        }
    }

    public void waitForElementToAppear(By element)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementToAppear(WebElement pElement)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(pElement));
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

    public String validateMsg(WebElement pElement)
    {
        waitForElementToAppear(pElement);
        return pElement.getText();
    }
    
}
