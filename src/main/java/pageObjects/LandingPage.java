package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage
{
    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='email@example.com']")
    WebElement username;

    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    WebElement login;

    public void loginApplication(String Username,String Password) throws InterruptedException
    {
        username.sendKeys(Username);
        password.sendKeys(Password);
        login.click();
        Thread.sleep(3000);
    }



}
