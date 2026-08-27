package tests;
import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Inventorypage;
import pages.Loginpage;

import java.util.List;
import java.util.stream.Collectors;



public class InventoryTest extends baseTest {
    private Inventorypage inventorypage;

    @BeforeMethod
    public void initializePage(){
        Loginpage loginpage=new Loginpage(driver);
        loginpage.login("standard_user","secret_sauce");
        inventorypage=new Inventorypage(driver);
        Assert.assertTrue(inventorypage.isInventoryDisplayed(),"Inventory page is not displaying after login");
    }

    @Test
    public void verifyLogoIsDisplayed(){
        Assert.assertEquals("Swag Labs",inventorypage.IsLogoDisplayed());
    }

    @Test
    public void verifyInventoryContainerDisplayed(){
        Assert.assertTrue(inventorypage.isInventoryContainerDisplayed(),"Inventory Items are not displayed");
    }

    @Test
    public void getProductCount(){
        Assert.assertEquals(inventorypage.getProductCount(),6,"Incorrect number of products displaeyed");
    }
    @Test
    public void verifyProductNamesareDisplayed(){
        List<String> products=inventorypage.getProductNames();
        Assert.assertEquals(products.size(),6,"Incorrect number of products");
        for(String product:products){
            Assert.assertFalse(product.trim().isEmpty(),"Product name is Empty");
        }
    }
    @Test
    public void verifyProductPriceAreDisplayed(){
        List<String> prices=inventorypage.getProductPrices();
        Assert.assertEquals(prices.size(),6,"Incorrect product prize count");
        for(String price:prices){
            Assert.assertTrue(price.startsWith("$"),"Invalid product prize"+price);
        }
    }

    @Test
    public void verifyProductImagesAreDisplayed(){
        Assert.assertEquals(inventorypage.getImageCount(),6,"Some product image are not displayed");
    }

    @Test
    public void verifyAddToCartButton(){
        Assert.assertEquals(inventorypage.getAddToCartButtonCount(),6,"The add to cart button is missing for some products");
    }

    @Test
    public void VerifyAddToCartButtonEnabled(){
        Assert.assertTrue(inventorypage.isAddToCartButtonEnabled(),"One or more AddToCart button are disabled");
    }

    @Test
    public void VerifyCartIcon(){
        Assert.assertTrue(inventorypage.isCartButtonIconDisplayed(),"Cart icon not displayed");
    }







}
