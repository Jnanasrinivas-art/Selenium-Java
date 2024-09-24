package Tests;

import Basecomponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import reportConfig.Retry;

import java.io.IOException;

public class Test_03 extends BaseTest {
    String testData_Sheet = "Test-sheet";

    @Test(priority = 1, description = "Login into the Application", retryAnalyzer = Retry.class)
    public void Test3() throws InterruptedException, IOException
    {
        abstrct_comp.loginApplication(testData_Sheet, 3);
    }
}
