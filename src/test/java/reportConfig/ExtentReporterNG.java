package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterNG
{
    @BeforeTest
    public static ExtentReports config()
    {
        ExtentSparkReporter sparkReporter;  // helper class for ExtentReports for making some UI configuration
        ExtentReports extentReport;   // Main class, which consolidates entire test execution

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path=System.getProperty("user.dir")+"/reports/myReport_"+timeStamp+".html";

        sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setDocumentTitle("Web Automation Results");
        sparkReporter.config().setReportName("Functional testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extentReport = new ExtentReports();
        extentReport.attachReporter(sparkReporter);
        extentReport.setSystemInfo("Test Engineer","Jnana Srinivas");
        return extentReport;
    }
}
