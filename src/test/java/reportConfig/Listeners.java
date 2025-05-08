package reportConfig;

import Basecomponent.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Listeners extends BaseTest implements ITestListener
{
    public ExtentReports extent=ExtentReporterNG.config();   // Main class, which consolidates entire test execution
    public ExtentTest test;    // used for storing,current instance particular test.

//    @Override
//    public void onStart(ITestContext context) {
//        extent = ExtentReporterNG.config(); // Create a new report for each context
//    }

    @Override
    public void onTestStart(ITestResult result)
    {
        test = extent.createTest(String.valueOf(result.getMethod().getDescription()));
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
        extent.flush();  //if not closed, it ll be in listening mode
    }

}
