package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class MP3PlayersPage extends BasePage {
    public WebDriver driver;
    private String addToCartBtn = "xpath=>//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[2]/button[1]";
    private String successMsg = "xpath=>//*[@id=\"product-category\"]/div[1]/a[1]";

    public MP3PlayersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void addiPodToCart() {
        elementClick(addToCartBtn, "Add To Cart Button");
    }

    public String getAddToCartSuccessMsg() {
        return getText(successMsg, "Add To Cart Success Msg");
    }
}
