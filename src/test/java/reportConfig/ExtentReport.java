package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport implements ITestListener
{

    public ExtentSparkReporter sparkReporter;  // helper class for ExtentReports for making some UI configuration
    public ExtentReports extentReport;   // Main class, which consolidates entire test execution
    public ExtentTest test;    // used for storing,current instance particular test.

    @Override
    public void onStart(ITestContext context)
    {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
        sparkReporter.config().setDocumentTitle("Web Automation Results");
        sparkReporter.config().setReportName("Functional testing");
        sparkReporter.config().setTheme(Theme.STANDARD);
        extentReport = new ExtentReports();
        extentReport.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        test = extentReport.createTest(String.valueOf(result.getMethod().getDescription()));

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        test.log(Status.FAIL,"Test failed");
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context)
    {
        extentReport.flush();  //if not closed, it ll be in listening mode
    }

}
