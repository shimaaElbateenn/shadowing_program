package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public WebDriver driver;
    private String title = "xpath=>//*[@id=\"content\"]/h2[1]";
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyValidLogin() {
        return isElementPresent(title, "My Account title");
    }
}
