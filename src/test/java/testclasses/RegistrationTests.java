package testclasses;

import base.BaseTest;
import org.example.pageclasses.NavigationPage;
import org.example.pageclasses.RegistrationPage;
import org.example.pageclasses.SuccessRegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Util;

import java.io.IOException;


public class RegistrationTests extends BaseTest {
    private boolean isExist;

    @BeforeClass
    public void setUp() {
        registrationPage = navigationPage.navigateToRegistrationPage();
    }

    @Test
    public void validRegistration() throws IOException {
        successRegistrationPage = registrationPage.insertData(
                "Shimaa", "Ismail", Util.getRandomString(7) + "@dxc.com", "01023456743", "sh123456");
        Assert.assertEquals(successRegistrationPage.CheckSuccessfulMessage(),
                "Congratulations! Your new account has been successfully created!");
        Assert.assertEquals(successRegistrationPage.CheckLogOut(), true);
        successRegistrationPage.Logout();
    }

    @Test
    public void invalidRegistration() throws IOException {
        registrationPage.insertData(
                "Shimaa", "Ismail", "", "", "");
        isExist = registrationPage.checkErrorMessages();
        Assert.assertTrue(isExist);
        registrationPage.insertData(
                "", "", Util.getRandomString(7) + "@dxc.com", "01238375871", "");
        isExist = registrationPage.passwordErrorMessages();
        Assert.assertTrue(isExist);
        registrationPage.insertData(
                "", "", "", "", "123");
        Assert.assertEquals(registrationPage.errorText, "Password must be between 4 and 20 characters!");
    }
}