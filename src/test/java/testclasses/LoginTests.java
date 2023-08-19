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
import java.util.ConcurrentModificationException;

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
    public void validLogin(String email, String password) throws IOException {
        LoginPage loginPage = navigationPage.navigateToLoginPage();
        MyAccountPage myAccountPage = loginPage.login(email, password);
        myAccountPage.verifyValidLogin();
    }

    @Test
    public void inValidLogin() throws IOException {
        LoginPage loginPage = navigationPage.navigateToLoginPage();
        loginPage.login("invalid@gmail.com", "wo1203kd9");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Warning: No match for E-Mail Address and/or Password.");
    }

}
