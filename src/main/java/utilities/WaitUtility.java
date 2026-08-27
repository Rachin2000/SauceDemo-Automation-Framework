package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
        private WebDriver driver;
        private WebDriverWait wait;

    public WaitUtility(WebDriver driver){
            this.driver=driver;

            int timeout=Integer.parseInt(ConfigReader.getProperty("explicitWait"));

            this.wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));

    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }


}
