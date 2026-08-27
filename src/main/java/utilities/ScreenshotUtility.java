package utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

        public static String captureScreenshot(WebDriver driver, String testName) {

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String screenshotPath =
                    System.getProperty("user.dir")
                            + "/test-output/screenshots/"
                            + testName + "_" + timestamp + ".png";

            try {

                File source =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.FILE);

                File destination = new File(screenshotPath);

                FileUtils.copyFile(source, destination);

                return screenshotPath;

            } catch (Exception e) {

                System.out.println("Screenshot capture failed: "
                        + e.getMessage());

                return null;
            }
        }
    }

