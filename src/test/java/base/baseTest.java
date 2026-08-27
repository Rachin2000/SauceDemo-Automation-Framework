package base;

import factory.DriverFactory;
import listeners.ExtentReportListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.ConfigReader;

@Listeners(ExtentReportListener.class)
public class baseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(ITestContext context) {

        driver = DriverFactory.driver();

        driver.manage().deleteAllCookies();

        driver.get(ConfigReader.getProperty("url"));

        System.out.println(
                "Current url: " + driver.getCurrentUrl()
        );

        // Make driver available to ExtentReportListener
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitdriver();
    }
}