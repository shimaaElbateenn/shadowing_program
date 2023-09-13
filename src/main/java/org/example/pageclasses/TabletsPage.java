package org.example.pageclasses;

import base.BasePage;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class TabletsPage extends BasePage {
    public WebDriver driver;
    private String lastElement = "css=>#product-category > ul > li:last-child";
    private String highLightedLink = "css=>#content > h2";
    private String addToCartBtn = "xpath=>//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/span";
    private String addtoCartMsg = "xpath=>//*[@id=\"product-category\"]/div[1]/a[1]";

    public TabletsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getLastLinkBreadCrumb() {
        return ElementActions.getInstance().getText(getByType(lastElement));
//        return getText(lastElement, "Last Link on Bread Crumb");
    }

    public String getHighlightedLink() {
        return ElementActions.getInstance().getText(getByType(highLightedLink));
//        return getText(highLightedLink, "Highlighted Link");
    }

    public String verifyAddingToCart() {
        ElementActions.getInstance().click(getByType(addToCartBtn));
        return ElementActions.getInstance().getText(getByType(addtoCartMsg));
//        elementClick(addToCartBtn, "Add To Cart");
//        waitForElement(addtoCartMsg, 15);
//        return getText(addtoCartMsg, "Added To Cart Message");
    }


}
