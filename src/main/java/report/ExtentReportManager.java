package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportManager {

    private static ExtentReports extent;


    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String reportPath =
                    System.getProperty("user.dir")
                            + "/test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("SauceDemo Automation Report");
            sparkReporter.config().setReportName("SauceDemo Test Automation");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Application", "SauceDemo");
            extent.setSystemInfo("Tester", "Rachin");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }

        return extent;
    }
}
