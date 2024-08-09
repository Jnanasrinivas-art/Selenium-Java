package Basecomponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest
{
    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("base_url");

        if(browserName.equalsIgnoreCase("chrome"))
        {
          driver= new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
           driver=new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("Edge"))
        {
            driver = new EdgeDriver();
        }
        else
        {
            System.out.println("please select proper browser");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        return driver;
    }

    @BeforeTest(alwaysRun = true)
    public void openBrowser() throws IOException
    {
       driver =initializeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser()
    {
        driver.quit();
    }
}
