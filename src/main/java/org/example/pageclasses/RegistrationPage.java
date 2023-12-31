package org.example.pageclasses;

import base.BasePage;
import com.shaft.gui.element.ElementActions;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;

public class RegistrationPage extends BasePage {
    public WebDriver driver;
    private String firstName = "id=>input-firstname";
    private String lastName = "id=>input-lastname";
    private String inputEmail = "id=>input-email";
    private String telephone = "id=>input-telephone";
    private String inputPassword = "id=>input-password";
    private String confirmPassword = "id=>input-confirm";
    private String agreement = "xpath=>//*[@id=\"content\"]/form/div/div/input[1]";
    private String continueButton = "xpath=>//input[@type=\"submit\"]";
    private String emailErrorMessage = "css=>#account > div:nth-child(5) > div > div";
    private String phoneErrorMessage = "xpath=>//*[@id=\"account\"]/div[5]/div/div";
    private String passwordErrorMessage = "xpath=>//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div";
    public String errorText;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SuccessRegistrationPage insertData(String fName, String lName, String email, String phone, String password) {
        ElementActions.getInstance().type(getByType(firstName), fName);
        ElementActions.getInstance().type(getByType(lastName), lName);
        ElementActions.getInstance().type(getByType(inputEmail), email);
        ElementActions.getInstance().type(getByType(telephone), phone);
        ElementActions.getInstance().type(getByType(inputPassword), password);
        ElementActions.getInstance().type(getByType(confirmPassword), password);
        Check(agreement, "Agreement");
       // ElementActions.getInstance().click(getByType(agreement));
        ElementActions.getInstance().click(getByType(continueButton));

//        sendData(firstName, fName, "First Name");
//        sendData(lastName, lName, "Last Name");
//        sendData(inputEmail, email, "Email");
//        sendData(telephone, phone, "Telephone");
//        sendData(inputPassword, password, "Password");
//        sendData(confirmPassword, password, "Confirm Password");
//        Check(agreement, "Agreement");
//        elementClick(continueButton, "Continue");
        return new SuccessRegistrationPage(driver);
    }

    public boolean checkErrorMessages() {
        waitForElement(emailErrorMessage, 15);
        boolean emailError = isElementPresent(emailErrorMessage, "Email Error Message");
        boolean phoneError = isElementPresent(phoneErrorMessage, "Phone Error Message");
        boolean passwordError = isElementPresent(passwordErrorMessage, "Password Error Message");
        System.out.println("emailError!!!!!!!!!!!!!!!!!" + emailError);
        System.out.println("phoneError!!!!!!!!!!!!!!!!!" + phoneError);
        System.out.println("passwordError!!!!!!!!!!!!!!!!!" + passwordError);

        boolean present;
        if (emailError && phoneError && passwordError) {
            present = true;
        } else {
            present = false;
        }
        return present;
    }

    public boolean passwordErrorMessages() {
        errorText = getText(passwordErrorMessage, "Password Error Message");
        return isElementPresent(passwordErrorMessage, "password Error Message");
    }
}
