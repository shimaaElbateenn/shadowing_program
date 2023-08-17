package org.example.pageclasses;

import base.BasePage;
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
    private String emailErrorMessage = "xpath=>//*[@id=\"account\"]/div[4]/div/div";
    private String phoneErrorMessage = "xpath=>//*[@id=\"account\"]/div[5]/div/div";
    private String passwordErrorMessage = "xpath=>//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div";
    public String errorText;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SuccessRegistrationPage insertData(String fName, String lName, String email, String phone, String password) throws IOException {
        File file = new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("validLogin");
        int rowNum = sheet.getLastRowNum() + 1;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(email);
        row.createCell(1).setCellValue(password);

        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
        workbook.write(outputStream);
        workbook.close();

        sendData(firstName, fName, "First Name");
        sendData(lastName, lName, "Last Name");
        sendData(inputEmail, email, "Email");
        sendData(telephone, phone, "Telephone");
        sendData(inputPassword, password, "Password");
        sendData(confirmPassword, password, "Confirm Password");
        Check(agreement, "Agreement");
        elementClick(continueButton, "Continue");
        return new SuccessRegistrationPage(driver);
    }

    public boolean checkErrorMessages() {
        boolean emailError = isElementPresent(emailErrorMessage, "Email Error Message");
        boolean phoneError = isElementPresent(phoneErrorMessage, "Phone Error Message");
        boolean passwordError = isElementPresent(passwordErrorMessage, "Password Error Message");

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

//    public void clearFields() {
//        driver.findElement(By.id(firstName)).clear();
//        driver.findElement(By.id(lastName)).clear();
//        driver.findElement(By.id(inputEmail)).clear();
//        driver.findElement(By.id(telephone)).clear();
//        driver.findElement(By.id(inputPassword)).clear();
//        driver.findElement(By.id(confirmPassword)).clear();
//    }
}
