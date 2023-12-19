package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Driver.browser;

public class Action {

    public static List<WebElement> getSearchResult(By locator) {
        SeleniumUtils.waitForAllElementsClickable(browser(), locator, 20);
        return browser().findElements(locator);
    }

    public static boolean elementIsDisplayed(WebElement element){
        return element.isDisplayed();
    }
}
