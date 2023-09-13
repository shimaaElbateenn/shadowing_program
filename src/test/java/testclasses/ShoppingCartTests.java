package testclasses;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Constants;

public class ShoppingCartTests extends BaseTest {

    @Test
    private void shoppingCart() {
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        tabletsPage = navigationPage.navigateToTablets();
        String successMsg = tabletsPage.verifyAddingToCart();
        Assert.assertTrue(successMsg.contains("Samsung Galaxy Tab 10.1"));
        shoppingCartPage = navigationPage.navigateToShoppingCart();
        Assert.assertTrue(shoppingCartPage.verifyProductExist());
        laptopPage = navigationPage.navigateToLaptop();
        laptopPage.addLaptop();
        laptopPage.changeDeliveryDate();
        String actualDeliveryDate = laptopPage.getDeliveryDate();
        laptopPage.addLaptopToCart();
        shoppingCartPage = navigationPage.navigateToShoppingCart();
        String deliveryDate = shoppingCartPage.getDeliveryDate();
        Assert.assertEquals(deliveryDate, "Delivery Date: " + actualDeliveryDate);
        shoppingCartPage.calculateTotalCost();
        float expectedTotalPrice = shoppingCartPage.calculateTotalCost();
        float actualTotalCost = shoppingCartPage.getFloatTotalCost();
        Assert.assertEquals(expectedTotalPrice, actualTotalCost);
        shoppingCartPage.removeProducts();
        String breakpoint = "";
    }

}
