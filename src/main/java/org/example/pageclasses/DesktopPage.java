package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class DesktopPage extends BasePage {
    public WebDriver driver;
    private String priceValue = "class=>price";
    private String currencyDropdown = "xpath=>//*[@id=\"form-currency\"]/div/button/span";
    private String euroCurrency = "xpath=>//*[@id=\"form-currency\"]/div/ul/li[1]/button";

    public DesktopPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getPrice() {
        return getText(priceValue, "Price");
    }

    public void ChaneCurrency() {
        elementClick(currencyDropdown, "Currency Dropdown");
        elementClick(euroCurrency, "Euro Currency");
    }
}
