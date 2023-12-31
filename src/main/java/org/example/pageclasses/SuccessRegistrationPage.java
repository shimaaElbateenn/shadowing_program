package org.example.pageclasses;

import base.BasePage;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessRegistrationPage extends BasePage {
    public WebDriver driver;
    private String successMessage = "xpath=>//*[@id=\"content\"]/p[1]";
    private String accountDropdown = "class=>caret";
    private String logout = "xpath=>//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a";
    public SuccessRegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String CheckSuccessfulMessage() {
        return ElementActions.getInstance().getText(getByType(successMessage));
        //return getText(successMessage, "Success Message");
    }

    public boolean CheckLogOut() {
        ElementActions.getInstance().click(getByType(accountDropdown));
        //elementClick(accountDropdown, "Account Dropdown");
        return isElementPresent(logout, "Logout");
    }

    public void Logout() {
        elementClick(logout, "Logout");
    }
}
