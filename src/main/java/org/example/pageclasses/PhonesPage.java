package org.example.pageclasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhonesPage extends BasePage {
    public WebDriver driver;
    private String inputSort = "id=>input-sort";
    private String sortByNameAtoZ = "xpath=>//*[@id=\"input-sort\"]/option[2]";
    private String sortByNameZtoA = "xpath=>//*[@id=\"input-sort\"]/option[3]";
    private String productName = "css=>.caption>h4>a";

    public PhonesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void chooseSortAscending() {
        elementClick(inputSort, "Input Sort");
        elementClick(sortByNameAtoZ, "Sort By Name A-Z");
    }

    public void chooseSortDescending() {
        elementClick(inputSort, "Input Sort");
        elementClick(sortByNameZtoA, "Sort By Name Z-A");
    }

    public boolean verifySortByName(String alphapitcaly) {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = getElementList(productName, "Product Name");
        for(WebElement we:elementList){
            obtainedList.add(getText(we, "Get Product Name"));
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for(String s:obtainedList){
            sortedList.add(s);
        }
        if (alphapitcaly == "ascending") {
            Collections.sort(sortedList);
        } else if (alphapitcaly == "descending") {
            Collections.reverse(sortedList);
        }
        return sortedList.equals(obtainedList);
    }
}
