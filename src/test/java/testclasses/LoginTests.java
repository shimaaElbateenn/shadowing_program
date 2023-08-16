package testclasses;

import base.BasePage;
import base.BaseTest;
import org.example.pageclasses.LoginPage;
import org.example.pageclasses.MyAccountPage;
import org.example.pageclasses.NavigationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest {


    @Test
    public void validLogin() {
        LoginPage loginPage = navigationPage.navigateToLoginPage();
        MyAccountPage myAccountPage = loginPage.validLogin("shimaa@dxc.com", "sh123456");
        myAccountPage.verifyValidLogin();
    }

    @Test
    public void inValidLogin() {
        LoginPage loginPage = navigationPage.navigateToLoginPage();
        loginPage.validLogin("ahmed@dxc.com", "sh23456");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Warning: No match for E-Mail Address and/or Password.");
    }

}
