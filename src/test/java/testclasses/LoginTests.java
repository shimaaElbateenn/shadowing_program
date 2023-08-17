package testclasses;

import base.BaseTest;
import org.example.pageclasses.LoginPage;
import org.example.pageclasses.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {
    @Test
    public void validLogin() throws IOException {
        LoginPage loginPage = navigationPage.navigateToLoginPage();
        MyAccountPage myAccountPage = loginPage.login(true);
        myAccountPage.verifyValidLogin();
    }

    @Test
    public void inValidLogin() throws IOException {
        LoginPage loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(false);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Warning: No match for E-Mail Address and/or Password.");
    }

}
