package pages;

import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestLogger;
import utilities.WaitUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loginpage {
        private WebDriver driver;
        private  WaitUtility wait;

public Loginpage(WebDriver driver){
        this.driver=driver;
        this.wait=new WaitUtility(driver);
        System.out.println("Login page initialized");
}

private static final Logger logger=LogManager.getLogger(Loginpage.class);


private By Username= By.xpath("//input[@id='user-name']");
private By Password=By.xpath("//input[@id='password']");
private By Loginbtn=By.xpath("//input[@id=\"login-button\"]");
private By InvalidcredentailsMessage=By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");
private By usernameRequiredMesssage=By.xpath("//h3[text()='Epic sadface: Username is required']");
private By passwordRequiredMessage=By.xpath("//h3[text()='Epic sadface: Password is required']");

//UI validations for LoginPage

    public boolean isUsernameFieldDisplayed(){
        logger.info("Validating the Username Field Displayed");
        TestLogger.info("Validating the username Field Displayed");
        return  driver.findElement(Username).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed(){
        logger.info("Validating the Password Field Displayed");
        TestLogger.info("Validating the Password Field Displayed");
        return  driver.findElement(Password).isDisplayed();
    }

    public boolean isLoginButtonDisplayed(){
        logger.info("Validating the Login Button Displayed");
        TestLogger.info("Validating the Login Button Displayed");
        return driver.findElement(Loginbtn).isDisplayed();
    }
    public boolean isLoginButtonEnabled(){
        logger.info("Validating the Login Button Enabled");
        TestLogger.info("Validating the Login Button Enabled");
        return driver.findElement(Loginbtn).isEnabled();
    }

    //password masking

    public String isPasswordFieldType(){
        logger.info("Validating the Password field is masked");
        TestLogger.info("Validating the Password field is masked");
        return  driver.findElement(Password).getAttribute("type");
    }

    public void enterUsername(String username){
        logger.info("Entering the Username: {}"+Username);
        TestLogger.info("Entering the username:");
    driver.findElement(Username).sendKeys(username);
}

public void enterPassword(String password){
    logger.info("Entering the Password: {}"+Password);
    TestLogger.info("Entering the Password");
    driver.findElement(Password).sendKeys(password);
}
public void clickLogin(){
    logger.info("Clicking on Login Button: {}"+Loginbtn);
    TestLogger.info("Clicking on Login button");
    driver.findElement(Loginbtn).click();
}

public void login(String username,String password)  {

    enterUsername(username);
    enterPassword(password);
    clickLogin();
}


//Invalid credentials

public boolean isInvalidCredentialsDisplayed() {
    TestLogger.info("Validating Login with invalid crdentials");
        try {
        return wait.waitForElementVisible(InvalidcredentailsMessage).isDisplayed();
    } catch (Exception e) {
            TestLogger.error("Invalid credentials element not found");
        System.out.println("Invalid credentials element not found");
    }
    return false;

}

//username required

public boolean isUsernameRequiredDisplayed(){
    TestLogger.info("Validating the Username Required message displayed");
    return driver.findElements(usernameRequiredMesssage).stream().anyMatch( element -> element.isDisplayed() && element.getText().equals("Epic sadface: Username is required"));

}

//password required
public boolean isPasswordRequiredDisplayed(){
    TestLogger.info("Validating the Password Required displayed");
    return driver.findElements(passwordRequiredMessage).stream().anyMatch(element -> element.isDisplayed() && element.getText().equals("Epic sadface: Password is required"));
}




}
