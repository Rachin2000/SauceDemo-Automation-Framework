package pages;

import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestLogger;
import utilities.WaitUtility;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Inventorypage {
    private WebDriver driver;
    private WaitUtility wait;

    private By Logo=By.xpath("//div[@class='app_logo']");
    private  By InventoryTitle= By.xpath("//span[text()='Products']");
    private By   InventoryContainer=By.xpath("//div[@class='inventory_container']");
    private By  InventoryItems=By.xpath("//div[@class='inventory_item']");
    private By productNames=By.xpath("//div[@class='inventory_item_name ']");
    private By productPrices=By.xpath("//div[@class='inventory_item_price']");
    private By productImages=By.xpath("//div[@class='inventory_item_img']");
    private By AddToCartButton=By.xpath("//button[text()='Add to cart']");
    private By cartIcon=By.xpath("//a[@class=\"shopping_cart_link\"]");


    private static final Logger logger=LogManager.getLogger(Inventorypage.class);


    public Inventorypage(WebDriver driver){
        this.driver=driver;
        this.wait=new WaitUtility(driver);
    }


    public String IsLogoDisplayed(){
        logger.info("Validating the Logo Displayed");
        TestLogger.info("Validating the Logo displayed");
        return driver.findElement(Logo).getText();
    }


    public boolean isInventoryDisplayed(){
        logger.info("Validating the Inventory is Displayed");
        TestLogger.info("Validating the Inventory is Displayed");

        try{
                return wait.waitForElementVisible(InventoryTitle).isDisplayed();
        }
        catch(Exception e){
            TestLogger.error("Inventory Title not found");
            return false;
        }
    }

    public boolean isInventoryContainerDisplayed(){
        logger.info("Validating the Inventory Container is Displayed");
        TestLogger.info("Validating the Inventory Container is displayed");
        return driver.findElement(InventoryContainer).isDisplayed();
    }

    public int getProductCount(){
        logger.info("Validating the Product count");
        TestLogger.info("Validating the Product count");
        return driver.findElements(InventoryItems).size();
    }

    public  int getImageCount(){
        logger.info("Validating the Product Image Count");
        TestLogger.info("Validating the Product Image count");
        return driver.findElements(productImages).size();
    }

    public int getAddToCartButtonCount(){
        logger.info("Validating the Add To Cart Button Count");
        TestLogger.info("Validating the Add To Cart Button count");
        return driver.findElements(AddToCartButton).size();
    }

    public boolean isCartButtonIconDisplayed(){
        logger.info("Validating the Cart Button Icon displayed");
        TestLogger.info("Validating the Cart Button Icon is displayed");
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductNameCount(){
        return driver.findElements(productNames).size();
    }

    public int getProductPriceCount(){
        return  driver.findElements(productPrices).size();
    }

    public List<String> getProductNames(){
        logger.info("Validating the Product names available in the Inventory");
        TestLogger.info("Validating the Product name available in the Inventory");
        //.stream() converts element into a stream
        //map(ele->ele.getText()) -- used to get text from each ele
        //.collect(Collectors.toList()) --converts everything to a list
        return driver.findElements(productNames).stream().map(element -> element.getText()).collect(Collectors.toList());
    }


    public List<String> getProductPrices(){
        logger.info("Validating the Product Prices");
        TestLogger.info("Validating the Product prices");
        return driver.findElements(productPrices).stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public boolean isAddToCartButtonEnabled(){
        logger.info("Validating the Add To Cart Button Enabled");
        TestLogger.info("Validating the Add To Cart Button Enabled");
        return driver.findElements(AddToCartButton).stream().allMatch(element -> element.isEnabled());
    }







}
