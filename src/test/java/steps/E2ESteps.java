package steps;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageclasses.NavigationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utilities.Constants;

public class E2ESteps extends BaseTest {

    @Given("user logged in to the app")
    public void user_logged_in_to_the_app() {
        driver = new ChromeDriver();
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        driver.manage().window().maximize();
        navigationPage = new NavigationPage(driver);
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
    }
    @When("user add ipod to the cart")
    public void user_add_ipod_to_the_cart() {
        mp3PlayersPage = navigationPage.navigateToMP3players();
        mp3PlayersPage.addiPodToCart();
        Assert.assertTrue(mp3PlayersPage.getAddToCartSuccessMsg().contains("iPod Shuffle"));
    }
    @When("user do checkout process and confirm order")
    public void user_do_checkout_process_and_confirm_order() {
        shoppingCartPage = navigationPage.navigateToShoppingCart();
        checkoutPage = shoppingCartPage.checkout();
        checkoutPage.fillBillingDetails("shimaa", "ahmed", "Alex", "Alex");
        String savedAddress = checkoutPage.checkAddressDropdown();
        Assert.assertEquals(savedAddress, "shimaa ahmed, Alex, Alex, Al Bahr al Ahmar, Egypt");
        checkoutPage.clickContinueAddress();
        checkoutPage.addCommentAndClickContinue("Test");
        checkoutPage.checkTermsAndConditions();
        confirmOrderPage = checkoutPage.confirmOrder();
    }
    @Then("order should be placed")
    public void order_should_be_placed() {
        Assert.assertEquals(confirmOrderPage.getConfirmOrderMsg(), "Your order has been successfully processed!");
        Assert.assertEquals(confirmOrderPage.getSmallSoppingCart(), "0 item(s) - $0.00");
    }
    @Then("user logout")
    public void user_logout() {
        navigationPage.logout();
    }
}
