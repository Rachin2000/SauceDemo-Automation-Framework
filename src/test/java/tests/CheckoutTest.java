package tests;

import base.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Cartpage;
import pages.Checkoutpage;
import pages.Loginpage;

public class CheckoutTest extends baseTest {
    private Checkoutpage checkoutpage;

    @BeforeMethod
    public void Initializepage(){
        Loginpage loginpage=new Loginpage(driver);
        loginpage.login("standard_user","secret_sauce");
        checkoutpage=new Checkoutpage(driver);
        Cartpage cartpage=new Cartpage(driver);
        cartpage.isCheckoutButtonEnabled();
    }

    @Test
    public void verifyFirstname(){
        checkoutpage.verifyFirstname();
    }

    @Test
    public void verifyLastname(){
        checkoutpage.verifyLastname();
    }

    @Test
    public void verifyPostcalCode(){
        checkoutpage.verifyPostalCode();
    }

    @Test
    public void verifyContinue() throws InterruptedException {
        checkoutpage.verifyContinueButton();
    }



}
