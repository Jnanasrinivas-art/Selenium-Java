package pageObjects;

import Abstractcomponents.Abstractcomponent;
import excelData.DataDriven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LandingPage extends Abstractcomponent
{
    public WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='email@example.com']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='userPassword']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    public WebElement login;

    public void loginApplication(String pSheet,int pRow) throws InterruptedException, IOException {
        String Username= DataDriven.readFromExcel(pSheet,"B",pRow);
        String Password=DataDriven.readFromExcel(pSheet,"C",pRow);
        enterValues(username,Username);
        enterValues(password,Password);
        clickElement(login);
        Thread.sleep(3000);
    }
}
