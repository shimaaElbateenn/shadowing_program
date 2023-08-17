package org.example.pageclasses;

import base.BasePage;
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

    public MyAccountPage login(boolean valid) throws IOException {
        File file = new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        if (valid) {
            sheet = workbook.getSheet("validLogin");
        } else {
            sheet = workbook.getSheet("invalidLogin");
        }
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        for(int i=0;i<=rowCount;i++){
            //int cellcount=sheet.getRow(i).getLastCellNum();
            System.out.println("Row"+ i+" data is :");
            sendData(inputEmail, sheet.getRow(1).getCell(0).getStringCellValue(), "Email");
            sendData(inputPassword, sheet.getRow(1).getCell(1).getStringCellValue(), "Password");
//            for(int j=0;j<cellcount;j++){
//                if (valid) {
//                    String validEmail = sheet.getRow(0).getCell(0).getStringCellValue();
//                } else {
//                    sendData(inputPassword, sheet.getRow(1).getCell(1).getStringCellValue(), "Password");
//                }
//            }
        }

        //sendData(inputPassword, password, "Password");
        elementClick(loginBtn, "Logging Button");
        return new MyAccountPage(driver);
    }

    public String getErrorMessage() {
        return getText(errorMessage, "Error Message");
    }
}
