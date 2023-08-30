package testclasses;

import base.BaseTest;
import org.example.pageclasses.LoginPage;
import org.example.pageclasses.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Constants;
import utilities.ExcelUtility;

import java.io.IOException;

public class LoginTests extends BaseTest {

    @DataProvider(name = "getLoginData")
    public Object[][] getLoginData() {
        Object[][] testData = ExcelUtility.getTestData("login");
        return testData;
    }

    @BeforeClass
    public void setUp() {
        ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "validLogin");
    }

    @Test(dataProvider = "getLoginData")
    public void validLogin(String email, String password) {
        loginPage = navigationPage.navigateToLoginPage();
        myAccountPage = loginPage.login(email, password);
        myAccountPage.verifyValidLogin();
        navigationPage.logout();
    }

    @Test
    public void inValidLogin() {
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login("invalid@gmail.com", "wo1203kd9");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Warning: No match for E-Mail Address and/or Password.");
    }

}
