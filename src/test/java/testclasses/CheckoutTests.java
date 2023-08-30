package testclasses;

import base.BaseTest;
import org.apache.tools.ant.taskdefs.Concat;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Constants;

public class CheckoutTests extends BaseTest {

    @Test
    private void checkoutAndConfirmOrder() {
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        mp3PlayersPage = navigationPage.navigateToMP3players();
        mp3PlayersPage.addiPodToCart();
        Assert.assertTrue(mp3PlayersPage.getAddToCartSuccessMsg().contains("iPod Shuffle"));
        shoppingCartPage = navigationPage.navigateToShoppingCart();
        String totalPrice = shoppingCartPage.getStringTotalCost();
        Assert.assertTrue(shoppingCartPage.verifyProductExist());
        checkoutPage = shoppingCartPage.checkout();
        checkoutPage.fillBillingDetails("shimaa", "ahmed", "Alex", "Alex");
        String savedAddress = checkoutPage.checkAddressDropdown();
        Assert.assertEquals(savedAddress, "shimaa ahmed, Alex, Alex, Al Bahr al Ahmar, Egypt");
        checkoutPage.clickContinueAddress();
        checkoutPage.addCommentAndClickContinue("Test");
        checkoutPage.checkTermsAndConditions();
        Assert.assertEquals(totalPrice, checkoutPage.getTotalPrice());
        confirmOrderPage = checkoutPage.confirmOrder();
        Assert.assertEquals(confirmOrderPage.getConfirmOrderMsg(), "Your order has been successfully processed!");
        Assert.assertEquals(confirmOrderPage.getSmallSoppingCart(), "0 item(s) - $0.00");
        navigationPage.logout();
    }

}
