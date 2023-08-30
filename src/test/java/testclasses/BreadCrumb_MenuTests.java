package testclasses;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Constants;

import java.io.IOException;

public class BreadCrumb_MenuTests extends BaseTest {

    @Test
    public void checkBreadCrumb_menu() {
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        tabletsPage = navigationPage.navigateToTablets();
        String latestLink = tabletsPage.getLastLinkBreadCrumb();
        Assert.assertEquals(latestLink, "Tablets");
        String highLightedLink = tabletsPage.getHighlightedLink();
        Assert.assertEquals(highLightedLink, "Tablets");
    }
}
