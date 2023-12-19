package org.example.page;

import org.example.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.example.Driver.browser;

public class WatchPage {
    private final By avatarLocator = By.xpath("//ytd-watch-metadata//yt-img-shadow[@id='avatar']");
    public AccountPage clickOnAvatar(){
        boolean isPresent;
        System.out.println("Redirect to video");
        SeleniumUtils.waitForAllElementsClickable(browser(), avatarLocator, 60);
        System.out.println("Wait for element");
        WebElement avatarElement = browser().findElement(avatarLocator);
        isPresent = avatarElement.isDisplayed();
        if (isPresent){
            avatarElement.click();
            System.out.println("Click on Avatar");
        }else {
            throw new NoSuchElementException("Avatar element not found " );
        }
        return new AccountPage();
    }
}
