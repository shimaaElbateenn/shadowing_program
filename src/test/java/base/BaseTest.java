package base;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.BrowserActions;
import io.cucumber.java.After;
import org.example.pageclasses.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.Constants;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected NavigationPage navigationPage;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected TabletsPage tabletsPage;
    protected DesktopPage desktopPage;
    protected SearchPage searchPage;
    protected SuccessRegistrationPage successRegistrationPage;
    protected MyAccountPage myAccountPage;
    protected PhonesPage phonesPage;
    protected ShoppingCartPage shoppingCartPage;
    protected LaptopPage laptopPage;
    protected MP3PlayersPage mp3PlayersPage;
    protected CheckoutPage checkoutPage;
    protected ConfirmOrderPage confirmOrderPage;

    @BeforeClass
    public void commonSetUp() throws Exception{
        FileReader reader = new FileReader(Constants.USER_DIRECTORY + "\\Data.properties");
        Properties props = new Properties();
        props.load(reader);

        driver = DriverFactory.getDriver();
        driver.get(props.getProperty("url"));
        driver.manage().window().maximize();
        navigationPage = new NavigationPage(driver);
    }

    @AfterClass
    public void commonTearDown() {
        driver.quit();
    }
}
