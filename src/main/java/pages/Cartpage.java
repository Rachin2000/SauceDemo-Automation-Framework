package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestLogger;
import utilities.WaitUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cartpage {

    private WebDriver driver;
    private WaitUtility wait;

    private By cartTitle=By.xpath("//span[text()='Your Cart']");
    private By cartItems=By.cssSelector(".cart_item");
    private By cartItemNames=By.cssSelector(".inventory_item_name");
    private By cartItemPrices=By.cssSelector("inventory_item_price");
    private By cartItemQuantity=By.cssSelector(".cart_quantity");
    private By checkoutButton=By.xpath("//button[text()='Checkout']");
    private By continueshoppingButton=By.id("continue-shopping");
    private By cartIcon=By.xpath("//a[@class='shopping_cart_link']");
    private By checkOutTitle=By.xpath("//span[text()='Checkout: Your Information']");


    private static final Logger logger=LogManager.getLogger(Cartpage.class);

    public Cartpage(WebDriver driver){
        this.driver=driver;
        this.wait=new WaitUtility(driver);
    }

    public void isCartIconClickable(){
        logger.info("Validate the Cart Icon clickable");
        TestLogger.info("Validating the cart icon clickable");
        driver.findElement(cartIcon).click();
    }

    public void getAddToCartbutton(String productName){
        logger.info("Validating the Add To Cart Button");
        TestLogger.info("Validating the Add To Cart Button");
        By addToCartButton = By.xpath(
                "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"
        );

        driver.findElement(addToCartButton).click();
    }


    public boolean isCartTitleDisplayed(){

        isCartIconClickable();
        logger.info("Validating the Cart Title Displayed");
        TestLogger.info("Validating the Cart title displayed");
        return driver.findElement(cartTitle).isDisplayed();
    }

    public String getCartTitle(){
        isCartIconClickable();
        logger.info("Validating the Cart Title");
        TestLogger.info("Validating the Cart Title");
        return driver.findElement(cartTitle).getText();
    }


    public int getCartItemCount(){
        isCartIconClickable();
        logger.info("Validating the Cart item count");
        TestLogger.info("Validating the cart item count");
        return driver.findElements(cartItems).size();
    }



    public int getCartItemNameCount(){
        return driver.findElements(cartItemNames).size();
    }

    public int getCartItemPriceCount(){
        return driver.findElements(cartItemPrices).size();
    }

    public boolean isCheckoutButtonDisplayed(){
        isCartIconClickable();
        logger.info("Validating the checkout button displayed");
        TestLogger.info("Validating the checkout button displayed");
        return driver.findElement(checkoutButton).isDisplayed();

    }

    public String getcartItemQuantity(){
        isCartIconClickable();
        logger.info("Validating the cart item quanity");
        TestLogger.info("Validating the cart item quanity");
        return driver.findElement(cartItemQuantity).getText();
    }

    public boolean isContinueShoppingButtonDisplayed(){
        isCartIconClickable();
        logger.info("Validating the Continue Shooping button displayed");
        TestLogger.info("Validating the Continue Shopping Button displayed");
        return driver.findElement(continueshoppingButton).isDisplayed();
    }

    public String getCheckoutTitle() {
        logger.info("Validating the Checkout Title displayed");
        TestLogger.info("Validating the Checkout Title displayed");
        return driver.findElement(checkOutTitle).getText();
    }

    public void isCheckoutButtonEnabled(){

        getAddToCartbutton("Sauce Labs Backpack");
        isCartIconClickable();
        driver.findElement(checkoutButton).click();
        getCheckoutTitle();
    }


}
