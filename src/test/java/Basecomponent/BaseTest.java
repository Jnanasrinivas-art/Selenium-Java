package Basecomponent;

import Abstractcomponents.Abstractcomponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest
{
    public WebDriver driver;
    protected LandingPage land_page;
    protected CartPage cart_page;
    protected Abstractcomponent abstrct_comp;
    protected CheckoutPage checkout_page;
    protected PaymentPage payment_page;

    public final int implicitwait=6;
    public final int page_timeout_load=10;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/globalData/GlobalData.properties");
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(page_timeout_load));
        return driver;
    }

    @BeforeClass(alwaysRun = true)
    public void openBrowser() throws IOException
    {
        driver =initializeDriver();
        land_page = new LandingPage(driver);
        cart_page = new CartPage(driver);
        abstrct_comp = new Abstractcomponent(driver);
        checkout_page = new CheckoutPage(driver);
        payment_page = new PaymentPage(driver);
    }
    
    @AfterClass(alwaysRun = true)
    public void closeBrowser()
    {
        driver.quit();
    }
    
}
