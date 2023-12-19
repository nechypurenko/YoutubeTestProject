package org.example.page;

import org.example.utils.Action;
import org.example.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Driver.browser;

public class ResultSearchPage {
    private final By resultVideoListLocator = By.xpath("//ytd-video-renderer");
    public WatchPage clickOnVideoByIndex(int index){
        SeleniumUtils.waitForAllElementsClickable(browser(), resultVideoListLocator, 10);
        List<WebElement> videoResultPage = Action.getSearchResult(resultVideoListLocator);
        if (!videoResultPage.isEmpty()){
            videoResultPage.get(index - 1).click();
            System.out.println("Click on video");
        }
        return new WatchPage();
    }
}
