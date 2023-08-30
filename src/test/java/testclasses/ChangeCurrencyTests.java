package testclasses;

import base.BaseTest;
import org.example.pageclasses.DesktopPage;
import org.example.pageclasses.LoginPage;
import org.example.pageclasses.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Constants;

import java.io.IOException;

public class ChangeCurrencyTests extends BaseTest {
    private String price;

    @Test
    public void changeCurrency() {
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        desktopPage = navigationPage.navigateToDesktopPage();
        price = desktopPage.getPrice();
        Assert.assertTrue(price.contains("$"));
        desktopPage.ChaneCurrency();
        price = desktopPage.getPrice();
        Assert.assertTrue(price.contains("€"));
        navigationPage.logout();
    }
}
