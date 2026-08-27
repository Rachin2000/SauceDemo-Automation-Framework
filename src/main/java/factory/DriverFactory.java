package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver driver() {

        if (driver.get() == null) {

            String browser = ConfigReader.getProperty("browser");

            switch (browser.toLowerCase()) {

                case "chrome":

                    ChromeOptions options = new ChromeOptions();

                    Map<String, Object> prefs = new HashMap<>();

                    // Disable Chrome password manager
                    prefs.put("credentials_enable_service", false);

                    // Disable password breach/leak detection popup
                    prefs.put("profile.password_manager_leak_detection", false);

                    options.setExperimentalOption("prefs", prefs);

                    driver.set(new ChromeDriver(options));

                    break;

                case "firefox":

                    driver.set(new FirefoxDriver());

                    break;

                case "edge":

                    driver.set(new EdgeDriver());

                    break;

                default:

                    throw new RuntimeException(
                            "Browser not supported: " + browser
                    );
            }

            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitdriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}