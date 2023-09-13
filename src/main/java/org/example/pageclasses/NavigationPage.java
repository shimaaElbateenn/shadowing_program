package org.example.pageclasses;

import base.BasePage;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    public WebDriver driver;
    private String accountDropdown = "xpath=>//*[@id=\"top-links\"]/ul/li[2]/a/span[1]";
    private String loginLink = "xpath=>//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a";
    private String registerLink = "xpath=>//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a";
    private String desktopLink = "xpath=>//*[@id=\"menu\"]/div[2]/ul/li[1]/a";
    private String showAllDesktop = "xpath=>//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a";
    private String logoutLink = "css=>#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a";
    private String tabletsLink= "xpath=>//*[@id=\"menu\"]/div[2]/ul/li[4]/a";
    private String searchBar = "xpath=>//input[@name=\"search\"]";
    private String searchButton = "xpath=>//*[@id=\"search\"]/span/button";
    private String phonesLink = "xpath=>//*[@id=\"menu\"]/div[2]/ul/li[6]/a";
    private String shoppingCartLink = "xpath=>//*[@id=\"top-links\"]/ul/li[4]/a/span";
    private String laptopNotebookLink = "xpath=>//*[@id=\"menu\"]/div[2]/ul/li[2]/a";
    private String showAllLaptopLink = "xpath=>//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a";
    private String MP3Players = "xpath=>//*[@id=\"menu\"]/div[2]/ul/li[8]/a";
    private String showAllMP3 = "xpath=>//*[@id=\"menu\"]/div[2]/ul/li[8]/div/a";

    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage() {
        waitForElement(accountDropdown, 15);
        elementClick(accountDropdown, "Account Dropdown");
        elementClick(loginLink, "Login Link");
//        ElementActions.getInstance().click(getByType(accountDropdown));
//        ElementActions.getInstance().click(getByType(loginLink));
        return new LoginPage(driver);
    }
    public RegistrationPage navigateToRegistrationPage() {
        ElementActions.getInstance().click(getByType(accountDropdown));
        ElementActions.getInstance().click(getByType(registerLink));
        return new RegistrationPage(driver);
    }

    public DesktopPage navigateToDesktopPage() {
        ElementActions.getInstance().click(getByType(desktopLink));
        ElementActions.getInstance().click(getByType(showAllDesktop));
//        elementClick(desktopLink, "Desktop Dropdown");
//        elementClick(showAllDesktop, "Show All Desktop");
        return new DesktopPage(driver);
    }

    public TabletsPage navigateToTablets() {
        ElementActions.getInstance().click(getByType(tabletsLink));
//        elementClick(tabletsLink, "Tablets Link");
        return new TabletsPage(driver);
    }

    public PhonesPage navigateTpPhonesPage(){
        ElementActions.getInstance().click(getByType(phonesLink));
//        elementClick(phonesLink, "Phones Link");
        return new PhonesPage(driver);
    }

    public ShoppingCartPage navigateToShoppingCart() {
        waitForElement(shoppingCartLink, 15);
        javascriptClick(shoppingCartLink, "Click Shopping cart");
        //ElementActions.getInstance().click(getByType(shoppingCartLink));
        //elementClick(shoppingCartLink, "Shopping Cart Link");
        return new ShoppingCartPage(driver);
    }

    public LaptopPage navigateToLaptop() {
        ElementActions.getInstance().click(getByType(laptopNotebookLink));
        ElementActions.getInstance().click(getByType(showAllLaptopLink));
//        elementClick(laptopNotebookLink, "Laptop Notebook");
//        elementClick(showAllLaptopLink, "Show All Laptop");
        return new LaptopPage(driver);
    }

    public MP3PlayersPage navigateToMP3players() {
//        ElementActions.getInstance().click(getByType(MP3Players));
//        ElementActions.getInstance().click(getByType(showAllMP3));
        elementClick(MP3Players, "MP3 Players");
        elementClick(showAllMP3, "Show All MP3 Players");
        return new MP3PlayersPage(driver);
    }

    public void logout() {
//        ElementActions.getInstance().click(getByType(accountDropdown));
//        ElementActions.getInstance().click(getByType(logoutLink));
        elementClick(accountDropdown, "Account Dropdown");
        elementClick(logoutLink, "Logout");
    }

    public SearchPage search(String keyword) {
//        ElementActions.getInstance().type(getByType(searchBar), keyword);
//        ElementActions.getInstance().click(getByType(searchButton));
        sendData(searchBar, keyword, "Search Keyword");
        elementClick(searchButton, "Search Button");
        return new SearchPage(driver);
    }

}
