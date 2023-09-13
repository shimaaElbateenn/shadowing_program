package org.example.pageclasses;

import base.BasePage;
import com.shaft.enums.internal.ElementAction;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    public WebDriver driver;
    private String fNameField = "id=>input-payment-firstname";
    private String lNameField = "id=>input-payment-lastname";
    private String addressField = "id=>input-payment-address-1";
    private String cityField = "id=>input-payment-city";
    private String countryField = "id=>input-payment-country";
    private String state = "id=>input-payment-zone";
    private String continueBtnPayment = "id=>button-payment-address";
    private String continueBtnShipping = "id=>button-shipping-address";
    private String continueBtnShipping2 = "id=>button-shipping-method";
    private String paymentMethodContinue = "id=>button-payment-method";
    private String newAddressOption = "xpath=>//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label/input";
    private String addressDropdown = "xpath=>//*[@id=\"shipping-existing\"]/select";
    private String savedAddress = "xpath=>//*[@id=\"shipping-existing\"]/select/option[2]";
    private String commentSection = "xpath=>//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea";
    private String termsCheckbox = "xpath=>//*[@id=\"collapse-payment-method\"]/div/div[3]/div/input[1]";
    private String totalPrice = "xpath=>//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[1]/td[2]";
    private String confirmOrderBtn = "id=>button-confirm";
    private String countryValue = "xpath=>//*[@id=\"input-payment-country\"]/option[70]";
    private String stateValue = "xpath=>//*[@id=\"input-payment-zone\"]/option[3]";


    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void fillBillingDetails(String fName, String lName, String address, String city) {
//        ElementActions.getInstance().click(getByType(newAddressOption));
//        ElementActions.getInstance().type(getByType(fNameField), fName);
//        ElementActions.getInstance().type(getByType(lNameField), lName);
//        ElementActions.getInstance().type(getByType(addressField), address);
//        ElementActions.getInstance().type(getByType(cityField), city);
//
//        ElementActions.getInstance().click(getByType(countryField));
//        ElementActions.getInstance().click(getByType(countryValue));
//        ElementActions.getInstance().click(getByType(state));
//        ElementActions.getInstance().click(getByType(stateValue));
//        ElementActions.getInstance().click(getByType(continueBtnPayment));

        Check(newAddressOption, "New Address");
        sendData(fNameField, fName, "First Name");
        sendData(lNameField, lName, "Last Name");
        sendData(addressField, address, "Address");
        sendData(cityField, city, "City");
        Select countryDropdown = new Select(getElement(countryField, "Country Field"));
        countryDropdown.selectByVisibleText("Egypt");
        Select stateDropdown = new Select(getElement(state, "state"));
        stateDropdown.selectByVisibleText("Al Bahr al Ahmar");
        elementClick(continueBtnPayment, "Continue Button");
    }

    public String checkAddressDropdown() {
        waitForElement(addressDropdown, 15);
//        ElementActions.getInstance().click(getByType(addressDropdown));
        elementClick(addressDropdown, "Address Dropdown");
//        return ElementActions.getInstance().getText(getByType(savedAddress));
        return getText(savedAddress, "Saved Address");
    }

    public void clickContinueAddress() {
//        ElementActions.getInstance().click(getByType(continueBtnShipping));
        elementClick(continueBtnShipping, "Continue Button");
    }

    public void addCommentAndClickContinue(String comment) {
//        ElementActions.getInstance().type(getByType(commentSection), comment);
//        ElementActions.getInstance().click(getByType(continueBtnShipping2));
        sendData(commentSection, comment, "Comment");
        elementClick(continueBtnShipping2, "Continue Button");
    }

    public void checkTermsAndConditions() {
//        ElementActions.getInstance().click(getByType(termsCheckbox));
//        ElementActions.getInstance().click(getByType(paymentMethodContinue));
        Check(termsCheckbox, "Terms And Conditions");
        elementClick(paymentMethodContinue, "Payment Method Continue");
    }

    public String getTotalPrice() {
        return getText(totalPrice, "Total Price");
    }

    public ConfirmOrderPage confirmOrder() {
//        ElementActions.getInstance().click(getByType(confirmOrderBtn));
        elementClick(confirmOrderBtn, "Confirm Order Button");
        return new ConfirmOrderPage(driver);
    }


}
