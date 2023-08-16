package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    public WebDriver driver;
    private String accountDropdown = "class=>caret";
    private String loginLink = "xpath=>//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a";
    private String registerLink = "xpath=>//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a";

    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage() {
        elementClick(accountDropdown, "Account Dropdown");
        elementClick(loginLink, "Login Link");
        return new LoginPage(driver);
    }
    public RegistrationPage navigateToRegistrationPage() {
        elementClick(accountDropdown, "Account Dropdown");
        elementClick(registerLink, "Register Link");
        return new RegistrationPage(driver);
    }

}
