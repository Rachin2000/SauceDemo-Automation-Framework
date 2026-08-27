package utilities;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import report.ExtentTestManager;

public class TestLogger {
    //this page is for Extent Report
    private static final Logger logger =
            LogManager.getLogger(TestLogger.class);


    public static void info(String message) {

        logger.info(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest()
                    .log(Status.INFO, message);
        }
    }


    public static void pass(String message) {

        logger.info(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest()
                    .log(Status.PASS, message);
        }
    }


    public static void warn(String message) {

        logger.warn(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest()
                    .log(Status.WARNING, message);
        }
    }


    public static void error(String message) {

        logger.error(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest()
                    .log(Status.FAIL, message);
        }
    }
}
