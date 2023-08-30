package testclasses;

import base.BasePage;
import base.BaseTest;
import org.example.pageclasses.LoginPage;
import org.example.pageclasses.NavigationPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Constants;

import java.io.IOException;

public class SearchTests extends BaseTest {

    @Test
    private void searchByName() {
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        searchPage = navigationPage.search("Mac");
        searchPage.productsTitleContains();
        navigationPage.logout();
    }

    @Test
    private void searchInSubcategories() {
        boolean present;
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        searchPage = navigationPage.search("Apple");
        searchPage.chooseComponent();
        present = searchPage.productExist();
        Assert.assertFalse(present);
        searchPage.checkSearchInSubcategory();
        String productTitle = searchPage.getProductName();
        Assert.assertEquals(productTitle, "Apple Cinema 30\"");
        navigationPage.logout();
    }
}
