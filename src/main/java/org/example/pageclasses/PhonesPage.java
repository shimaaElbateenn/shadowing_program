package org.example.pageclasses;

import base.BasePage;
import org.jvnet.hk2.internal.Collector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        waitForElement(inputSort, 15);
        elementClick(inputSort, "Input Sort");
        elementClick(sortByNameAtoZ, "Sort By Name A-Z");
    }

    public void chooseSortDescending() {
        waitForElement(inputSort,15);
        elementClick(inputSort, "Input Sort");
        elementClick(sortByNameZtoA, "Sort By Name Z-A");
    }

    public boolean verifySortByName(String alphapitcaly) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForElement(productName, 15);
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = getElementList(productName, "Product Name");
        for(WebElement we:elementList){
            obtainedList.add(getText(we, "Get Product Name").toLowerCase());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for(String s:obtainedList){
            sortedList.add(s.toLowerCase());
            System.out.println("index " + s);
        }
        if (alphapitcaly == "ascending") {
            System.out.println("Before ascending" + sortedList);
            Collections.sort(sortedList);
            System.out.println("After ascending" + sortedList);
        } else if (alphapitcaly == "descending") {
            System.out.println("Before descending" + sortedList);
            Collections.reverse(sortedList);
            System.out.println("after descending" + sortedList);
        }
        return sortedList.equals(obtainedList);
    }
}
