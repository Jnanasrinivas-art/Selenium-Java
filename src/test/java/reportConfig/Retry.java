package reportConfig;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
    int retrycount=0;
    public static final int MAX_TRY=2;

    @Override
    public boolean retry(ITestResult result)
    {
        if(retrycount<MAX_TRY)
        {
            retrycount++;
            return true;
        }
        return false;
    }
}
