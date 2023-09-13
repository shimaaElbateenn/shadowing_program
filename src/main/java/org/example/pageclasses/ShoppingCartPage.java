package org.example.pageclasses;

import base.BasePage;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.WebDriver;

import java.math.BigInteger;
import java.util.Arrays;

public class ShoppingCartPage extends BasePage {
    public WebDriver driver;
    private String productTitle = "xpath=>//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a";
    private String product1Price = "xpath=>//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]";
    private String product2Price = "xpath=>//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[5]";
    private String deliveryDate = "xpath=>//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[2]/small[1]";
    private String totalCost = "css=>#content > div.row > div > table > tbody > tr:nth-child(2) > td:nth-child(2)";
    private String checkoutLink = "xpath=>//*[@id=\"content\"]/div[3]/div[2]/a";
    private String removeProduct1 = "xpath=>//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]";
    private String removeProduct2 = "xpath=>//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]";


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyProductExist() {
        waitForElement(productTitle, 20);
        return isElementPresent(productTitle, "Title") && isElementPresent(product1Price, "Price");
    }

    public String getDeliveryDate() {
        waitForElement(deliveryDate, 20);
        return ElementActions.getInstance().getText(getByType(deliveryDate));
        //return getText(deliveryDate, "Delivery Date");
    }

    public float calculateTotalCost() {
        String firstProductPrice = getText(product1Price, "Product 1 Price").substring(1);
        float product1price = Float.parseFloat(firstProductPrice.trim());
        String secondProductPrice = getText(product2Price, "Product 2 Price").substring(1);
        float product2price = Float.parseFloat(secondProductPrice);
        float total = product1price + product2price;
        String totalString = String.valueOf(total);
        System.out.println(totalString);
        return product1price + product2price;
    }

    public float getFloatTotalCost() {
        return Float.parseFloat(getText(totalCost, "Total Cost").substring(1));
    }

    public String getStringTotalCost() {
        return ElementActions.getInstance().getText(getByType(totalCost));
//        return getText(totalCost, "Total Cost");
    }

    public CheckoutPage checkout() {
       // ElementActions.getInstance().click(getByType(checkoutLink));
        elementClick(checkoutLink, "Checkout");
        return new CheckoutPage(driver);
    }

    public void removeProducts() {
        ElementActions.getInstance().click(getByType(removeProduct1));
        waitForElement(removeProduct2, 15);
        javascriptClick(removeProduct2, "Remove Product");
        //ElementActions.getInstance().click(getByType(removeProduct2));
    }

}
