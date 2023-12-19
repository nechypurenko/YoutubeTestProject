package org.example.page;

import org.example.utils.Action;
import org.example.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Driver.browser;

public class YoutubeStartPage {
    private final By searchResultList = By.xpath("//*[@role='option']");
    private final By searchInputPath = By.name("search_query");
    public YoutubeStartPage() {
    }
    public void setText(String query) {
        long startTime = System.currentTimeMillis();
        WebElement searchInput = SeleniumUtils.waitForElementPresence(browser(), searchInputPath, 10);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("wait for searchInput take " + executionTime + " milliseconds to execute.");
        searchInput.clear();
        searchInput.click();
        searchInput.sendKeys(query);
        System.out.println("send key " + query);
    }

    public WebElement getItemResult(int index){
        List<WebElement> searchResult = Action.getSearchResult(searchResultList);
        if (!searchResult.isEmpty()){
            return searchResult.get(index - 1);
        }
        return null;
    }
    public ResultSearchPage clickOnItemResultByIndex(int index) {
        try {
            WebElement resultItemElement = getItemResult(index);
            if (resultItemElement != null) {
                resultItemElement.click();
            } else {
                throw new NoSuchElementException("Result item not found at index: " + index);
            }
            return new ResultSearchPage();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }
}
