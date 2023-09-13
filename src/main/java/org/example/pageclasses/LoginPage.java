package org.example.pageclasses;

import base.BasePage;
import com.shaft.enums.internal.ElementAction;
import com.shaft.gui.element.ElementActions;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LoginPage extends BasePage {
    public WebDriver driver;
    private String inputEmail = "id=>input-email";
    private String inputPassword = "id=>input-password";
    private String loginBtn = "xpath=>//input[@type=\"submit\"]";
    private String errorMessage= "xpath=>//*[@id=\"account-login\"]/div[1]";
    private Sheet sheet;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MyAccountPage login(String email, String password) {
//        ElementActions.getInstance().type(getByType(inputEmail), email);
//        ElementActions.getInstance().type(getByType(inputPassword), password);
//        ElementActions.getInstance().click(getByType(loginBtn));
        sendData(inputEmail, email, "Email");
        sendData(inputPassword, password, "Password");
        elementClick(loginBtn, "Logging Button");
        return new MyAccountPage(driver);
    }

    public String getErrorMessage() {
        waitForElement(errorMessage, 15);
        //return ElementActions.getInstance().getText(getByType(errorMessage));
        return getText(errorMessage, "Error Message");
    }
}
