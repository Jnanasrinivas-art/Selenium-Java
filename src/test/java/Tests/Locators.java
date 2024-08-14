package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators
{
    WebDriver driver;

    @Test
    public void locatorExamples()
    {
        driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        //Using css-id locator
        WebElement username = driver.findElement(By.cssSelector("input#userEmail"));
        username.sendKeys("jnanasr@gmail.com");

        //Using css-attribute selector
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("Krishna1992@");

        //Using css-class locator
         WebElement login = driver.findElement(By.cssSelector("input.btn"));
         login.click();

        //Using linkText
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot password?"));
        forgotPassword.click();

        //Using xpath
        //tagName[@attribute="value"]
        WebElement home = driver.findElement(By.xpath("//button[@class='btn btn-custom']"));
        home.click();
        

    }




}
