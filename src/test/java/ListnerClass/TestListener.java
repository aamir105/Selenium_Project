package ListnerClass;

import com.Jooble.qa.base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.Logger;

public class TestListener extends TestBase implements ITestListener {

    private static Logger logger = Logger.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started: " + result.getName());

        // Create Extent Test node for each test
        extentTest = extent.createTest(result.getMethod().getMethodName());
        extentTest.log(Status.INFO, "Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: " + result.getName());

        // Log test result to Extent Report
        extentTest.log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getName());
        logger.error("Cause: " + result.getThrowable());

        // Log failure to Extent Report and attach screenshot
        extentTest.log(Status.FAIL, "Test Failed: " + result.getName());
        extentTest.log(Status.FAIL, result.getThrowable());

        // Capture and attach screenshot
        TestBase.takeScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: " + result.getName());

        // Log skipped test to Extent Report
        extentTest.log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started: " + context.getName());

        // Initialize Extent Reports
        TestBase.initializeExtentReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finished: " + context.getName());

        // Flush the Extent Report to finalize it
        extent.flush();
    }
}
