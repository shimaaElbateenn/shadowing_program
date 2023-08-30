package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPage extends BasePage {

    public WebDriver driver;
    private String confirmOrderMsg = "xpath=>//*[@id=\"content\"]/p[1]";
    private String smallSoppingCart = "xpath=>//*[@id=\"cart-total\"]";

    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getConfirmOrderMsg() {
        return getText(confirmOrderMsg, "Confirm Order Message");
    }

    public String getSmallSoppingCart() {
        return getText(smallSoppingCart, "Small Shipping Cart");
    }
}
