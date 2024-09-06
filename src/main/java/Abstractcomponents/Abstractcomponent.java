package Abstractcomponents;

import excelData.DataDriven;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

    public void scrollTillElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
}
