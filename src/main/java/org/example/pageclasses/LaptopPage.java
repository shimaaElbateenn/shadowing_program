package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class LaptopPage extends BasePage {
    public WebDriver driver;
    private String addBtn = "xpath=>//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[1]";
    private String calenderBtn = "xpath=>//*[@id=\"product\"]/div[1]/div/span/button/i";
    private String date = "xpath=>/html/body/div[3]/div/div[1]/table/tbody/tr[4]/td[6]";
    private String addToCartBtn = "id=>button-cart";

    public LaptopPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void addLaptop() {
        elementClick(addBtn, "Add Button");
    }

    public void changeDeliveryDate() {
        elementClick(calenderBtn, "Calender Button");
        elementClick(date, "Choose Date");
    }

    public void addLaptopToCart() {
        elementClick(addToCartBtn, "Add to Cart Button");
    }
}
