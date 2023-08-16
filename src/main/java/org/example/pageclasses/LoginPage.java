package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public WebDriver driver;
    private String inputEmail = "id=>input-email";
    private String inputPassword = "id=>input-password";
    private String loginBtn = "xpath=>//input[@type=\"submit\"]";
    private String errorMessage= "xpath=>//*[@id=\"account-login\"]/div[1]";
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MyAccountPage validLogin(String email, String password) {
        sendData(inputEmail, email, "Email");
        sendData(inputPassword, password, "Password");
        elementClick(loginBtn, "Logging Button");
        return new MyAccountPage(driver);
    }

    public String getErrorMessage() {
        return getText(errorMessage, "Error Message");
    }
}
