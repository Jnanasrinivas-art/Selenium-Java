package pageObjects;

import Abstractcomponents.Abstractcomponent;
import excelData.DataDriven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LandingPage extends Abstractcomponent
{
    public WebDriver driver;

    String Username;
    String Password;
    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='email@example.com']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='userPassword']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    public WebElement login;

    public void loginApplication() throws InterruptedException, IOException {
        Username= DataDriven.readFromExcel("testdata","B",3);
        Password=DataDriven.readFromExcel("testdata","C",3);
        username.sendKeys(Username);
        password.sendKeys(Password);
        login.click();
        Thread.sleep(3000);
    }



}
