package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestLogger;
import utilities.WaitUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Checkoutpage {


    private WebDriver driver;
    private WaitUtility wait;


    private By Firstname=By.id("first-name");
    private By Lastname=By.id("last-name");
    private By PostalCode=By.id("postal-code");
    private By ContinueButton=By.id("continue");
    private By FinishButton=By.id("finish");
    private By Thankyoumessage=By.xpath("//h2[text()='Thank you for your order!']");
    private By GeneratePDFButton=By.id("generate-pdf-order");


    private static final Logger logger=LogManager.getLogger(Checkoutpage.class);

    public Checkoutpage(WebDriver driver){
        this.driver=driver;
        this.wait=new WaitUtility(driver);
    }

    public void verifyFirstname(){
        logger.info("Validating the Firstname");
        TestLogger.info("Validating the First name");
        driver.findElement(Firstname).isDisplayed();
        driver.findElement(Firstname).sendKeys("Rachin");
    }

    public void verifyLastname(){
        logger.info("Validating the Lastname");
        TestLogger.info("Validating the Lastname");
        driver.findElement(Lastname).isDisplayed();
        driver.findElement(Lastname).sendKeys("Rachin");
    }

    public void verifyPostalCode(){
        logger.info("Validating the Postalcode");
        TestLogger.info("Validating the Postal code");
        driver.findElement(PostalCode).isDisplayed();
        driver.findElement(PostalCode).sendKeys("560098");
    }

    public void verifyContinueButton() throws InterruptedException {

        verifyFirstname();
        verifyLastname();
        verifyPostalCode();
        logger.info("Validating the Continue Button displayed");
        TestLogger.info("Validating the Continue button displayed");
        driver.findElement(ContinueButton).isDisplayed();
        logger.info("Validating the Continue Button clicked");
        TestLogger.info("Validating the Continue Button clicked");
        driver.findElement(ContinueButton).click();
        logger.info("Validating the Finish Button");
        TestLogger.info("Validating the Finish Button");
        driver.findElement(FinishButton).click();
        logger.info("Validating the Thank yoiu message");
        TestLogger.info("Validating the Thank you message");
        driver.findElement(Thankyoumessage).isDisplayed();
        logger.info("Validating the Generate PDF Button displayed");
        TestLogger.info("Validating the Genrate PDF Buttn displayed");
        driver.findElement(GeneratePDFButton).isDisplayed();
      Thread.sleep(3000);
        logger.info("Validating the Generate PDF Button clicked");
        TestLogger.info("Validating the Generate PDF button clicked");
        driver.findElement(GeneratePDFButton).click();
    }










}
