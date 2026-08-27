package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Cartpage;
import pages.Loginpage;

import static factory.DriverFactory.driver;

public class CartTest extends baseTest {
    private Cartpage cartpage;

    @BeforeMethod
    public void InitializeLaunchpage(){
        Loginpage loginpage=new Loginpage(driver);
        loginpage.login("standard_user","secret_sauce");
        cartpage=new Cartpage(driver);

    }

    @Test
    public void verifyCartPageIsDisplayed(){
        Assert.assertTrue(cartpage.isCartTitleDisplayed(),"Cart Title is not displayed");
    }

    @Test
    public void verifyEmptyCart(){
        Assert.assertEquals(cartpage.getCartItemCount(),0,"Cart is not empty");

    }

    @Test
    public void verifyCartButtons(){


        Assert.assertTrue(cartpage.isCheckoutButtonDisplayed(), "checkout button not displayed");

        Assert.assertTrue(cartpage.isContinueShoppingButtonDisplayed(), "continue shopping button not dispalyed");
    }

    @Test
    public void verifyCartPageTitle(){
        Assert.assertEquals(cartpage.getCartTitle(),"Your Cart");
    }

    @Test
    public void verifyItemAddedToCart(){
        cartpage.getAddToCartbutton("Sauce Labs Backpack");
        cartpage.isCartIconClickable();
        Assert.assertEquals(cartpage.getCartItemCount(),1,"Incorrect number of counts");

        Assert.assertEquals(cartpage.getcartItemQuantity(),"1","Incorrect Item quantity");
    }

    @Test
    public void verifyCheckOutButton(){
        cartpage.isCheckoutButtonEnabled();


    }












}
