package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Inventorypage;
import pages.Loginpage;
import factory.DriverFactory;
import utilities.ConfigReader;
import dataProvider.DataProviderClass;



public class LoginTest extends baseTest {
    //Instead of initializing Loginpage in every test , i'll create a before method for it
    protected Loginpage loginpage;

    @BeforeMethod
    public void  setLoginpage(){
        loginpage=new Loginpage(driver);
    }


@Test
public void verifyLoginPageUIElements(){
   // Loginpage loginpage=new Loginpage(DriverFactory.driver());

    Assert.assertTrue(loginpage.isUsernameFieldDisplayed(),"Username field is not displayed");

    Assert.assertTrue(loginpage.isPasswordFieldDisplayed(),"Password field is not displayed");

    Assert.assertTrue(loginpage.isLoginButtonDisplayed(), "Login button is not displayed");

    Assert.assertTrue(loginpage.isLoginButtonEnabled(),"Login button is not enabled");
}

@Test
public void verifyPasswordFieldIsMasked(){
        String fieldType=loginpage.isPasswordFieldType();
        Assert.assertEquals(fieldType,"password","password is masked");

}

@Test(dataProvider = "loginData",dataProviderClass = DataProviderClass.class)
public void verifyValidLogin(String username,String password,String expectedResult, String expectedMessage)  {

    //String username= ConfigReader.getProperty("username");
    //String password=ConfigReader.getProperty("password");
    //String url=ConfigReader.getProperty("url");
    //DriverFactory.driver().get(url);
    System.out.println(
            "Executing Login Test with: "
                    + username + "/" + password
    );
    System.out.println(
            "Expected Result: [" + expectedResult + "]"
    );

    System.out.println(
            "Expected Message: [" + expectedMessage + "]"
    );
    //Loginpage loginpage=new Loginpage(DriverFactory.driver());
    loginpage.login(username,password);
    System.out.println(
            "URL after login: " + driver.getCurrentUrl()
    );

    //Successfull login
    if(expectedResult.equalsIgnoreCase("Success")){
        Inventorypage InventoryPage=new Inventorypage(driver);
        Assert.assertTrue(InventoryPage.isInventoryDisplayed(),"Inventory not displayed after login");
    }
    else{
        //Invalid username/password
        if(expectedMessage.equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service")){
                Assert.assertTrue(loginpage.isInvalidCredentialsDisplayed(),"Login failed , but the Invalid credentials message not displayed");
        }
        else if (expectedMessage.equalsIgnoreCase("Epic sadface: Username is required")){
                Assert.assertTrue(loginpage.isUsernameRequiredDisplayed(),"username required message not displayed");
        }
        else if(expectedMessage.equalsIgnoreCase("Epic sadface: Password is required")){
                Assert.assertTrue(loginpage.isPasswordRequiredDisplayed(),"Passsword Required message not displayed");
        }
        else{
                Assert.fail("Unkown expected message in Excel: "+expectedMessage);
        }

    }

    //Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "user did not login");

}
}
