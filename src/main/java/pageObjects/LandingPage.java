package pageObjects;

import Abstractcomponents.Abstractcomponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Abstractcomponent
{
    WebDriver driver;
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

    public void loginApplication(String Username,String Password) throws InterruptedException
    {
        username.sendKeys(Username);
        password.sendKeys(Password);
        login.click();
        Thread.sleep(3000);
    }



}
