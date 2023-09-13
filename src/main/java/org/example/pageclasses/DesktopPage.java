package org.example.pageclasses;

import base.BasePage;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.WebDriver;

public class DesktopPage extends BasePage {
    public WebDriver driver;
    private String priceValue = "xpath=>//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/p[2]/span[1]";
    private String currencyDropdown = "xpath=>//*[@id=\"form-currency\"]/div/button/span";
    private String euroCurrency = "xpath=>//*[@id=\"form-currency\"]/div/ul/li[1]/button";

    public DesktopPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getPrice() {
        return ElementActions.getInstance().getText(getByType(priceValue));
        //return getText(priceValue, "Price");
    }

    public void ChaneCurrency() {
        ElementActions.getInstance().click(getByType(currencyDropdown));
        ElementActions.getInstance().click(getByType(euroCurrency));
//        elementClick(currencyDropdown, "Currency Dropdown");
//        elementClick(euroCurrency, "Euro Currency");
    }
}
