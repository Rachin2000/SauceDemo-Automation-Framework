package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.ExtentReportManager;
import report.ExtentTestManager;
import factory.DriverFactory;
import utilities.ScreenshotUtility;
import org.openqa.selenium.WebDriver;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extent =
            ExtentReportManager.getReportInstance();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTestManager.setTest(
                extent.createTest(result.getMethod().getMethodName())
        );

        ExtentTestManager.getTest()
                .log(Status.INFO, "Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.FAIL, "Test failed");

        ExtentTestManager.getTest()
                .log(Status.FAIL, result.getThrowable());

        WebDriver driver=DriverFactory.getDriver();

        //capture screenshot
        String screenshotPath=ScreenshotUtility.captureScreenshot(driver,result.getMethod().getMethodName());

        if (screenshotPath != null) {

            ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        extent.flush();

        ExtentTestManager.removeTest();
    }
}
