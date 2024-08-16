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
    public void locatorExamples() throws InterruptedException {
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

        //Using contains
        WebElement Signout = driver.findElement(By.xpath("//button[@class='btn btn-custom' and contains(.,' Sign Out ')]"));
        Signout.click();
        Thread.sleep(2000);

        //Using css parent-child traversing
        //Syntax : parent child
        //Using xpath parent-child traversing
        //Syntax : //parent/child

        WebElement username1 = driver.findElement(By.cssSelector("div input"));
        username1.sendKeys("jnanasr@gmail.com");

        WebElement password1 = driver.findElement(By.cssSelector("form div:nth-child(2) input"));
        password1.sendKeys("Krishna1992@");
        Thread.sleep(3000);

        WebElement login1 = driver.findElement(By.cssSelector("input.btn"));
        login1.click();

        WebElement AddToCart = driver.findElement(By.xpath("//button[contains(@class,'w-10 rounded')]"));
        AddToCart.click();

        Thread.sleep(6000);

        WebElement Cart = driver.findElement(By.cssSelector("button[routerlink*='cart']"));
        Cart.click();

    }




}
