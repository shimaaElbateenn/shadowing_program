package base;

import org.example.pageclasses.MyAccountPage;
import org.example.pageclasses.NavigationPage;
import org.example.pageclasses.RegistrationPage;
import org.example.pageclasses.SuccessRegistrationPage;
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
    protected String baseURL;
    protected NavigationPage navigationPage;
    protected RegistrationPage registrationPage;
    protected SuccessRegistrationPage successRegistrationPage;
    protected MyAccountPage myAccountPage;

    @BeforeClass
    public void commonSetUp() throws Exception{
        FileReader reader = new FileReader(Constants.USER_DIRECTORY + "\\Data.properties");
        Properties props = new Properties();
        props.load(reader);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(props.getProperty("url"));
        driver.manage().window().maximize();
        navigationPage = new NavigationPage(driver);
    }

    @AfterClass
    public void commonTearDown() {
        driver.quit();
    }
}
