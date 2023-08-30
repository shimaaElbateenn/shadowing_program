package testclasses;

import base.BaseTest;
import org.testng.annotations.Test;
import utilities.Constants;

public class SortTests extends BaseTest {

    @Test
    public void sortByName() {
        loginPage = navigationPage.navigateToLoginPage();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        phonesPage = navigationPage.navigateTpPhonesPage();
        phonesPage.chooseSortAscending();
        phonesPage.verifySortByName("ascending");
        phonesPage.chooseSortDescending();
        phonesPage.verifySortByName("descending");
    }
}
