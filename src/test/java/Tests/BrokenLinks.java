package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BrokenLinks
{
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //broken Links
        // Java methods will call URL's and gets you the status code
        // if status code >400 then that url is not working -> link which tied to url is broken

        driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

         HttpURLConnection con= (HttpURLConnection) new URL(url).openConnection();

         con.setRequestMethod("HEAD");
         con.connect();
         int respCode = con.getResponseCode();
         System.out.println(respCode);
    }
}
