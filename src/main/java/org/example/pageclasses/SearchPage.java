package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    public WebDriver driver;
    private String productTitle = "xpath=>//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a";
    private String categoryDropdown = "xpath=>//select[@name='category_id']";
    private String componentOption= "xpath=>//*[@id=\"content\"]/div/div[2]/select/option[8]";
    private String searchBtn = "id=>button-search";
    private String product = "class=>.product-layout";
    private String searchInSubcategory = "xpath=>//input[@name='sub_category']";

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean productsTitleContains() {
        boolean contains = false;
        List<WebElement> elements = getElementList(productTitle, "product Title");
        for (WebElement webElement : elements) {
            String title = getText(webElement, "Product title");
            if (title.contains("Mac")) {
                contains = true;
            }
        }
        return contains;
    }

    public void chooseComponent() {
        elementClick(categoryDropdown, "Category Dropdown");
        elementClick(componentOption, "Component Option");
        elementClick(searchBtn, "Search Button");
    }

    public boolean productExist() {
        return isElementPresent(product, "Product");
    }

    public void checkSearchInSubcategory() {
        Check(searchInSubcategory, "Search In Subcategory");
        elementClick(searchBtn, "Search Button");
    }

    public String getProductName() {
        return getText(productTitle, "Product Title");
    }
}
