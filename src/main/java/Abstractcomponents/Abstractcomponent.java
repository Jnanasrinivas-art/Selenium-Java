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
import java.util.Random;


public class Abstractcomponent
{
   public WebDriver driver;

   String Username;
   String Password;

   //int number;

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

    public void loginApplication() throws InterruptedException, IOException {
        Username= DataDriven.readFromExcel("testdata","B",3);
        Password=DataDriven.readFromExcel("testdata","C",3);
        username.sendKeys(Username);
        password.sendKeys(Password);
        login.click();
        Thread.sleep(3000);
    }

    public void waitForElementToAppear(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickCartPage() throws InterruptedException {
        Thread.sleep(3000);
        CartPage.click();
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
