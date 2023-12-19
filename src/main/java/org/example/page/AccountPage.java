package org.example.page;

import org.example.utils.Action;
import org.example.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.example.Driver.browser;

public class AccountPage {
By subscribeBtnPath = By.xpath("//button[@aria-label='Subscribe']");
By signInTextPath = By.xpath("//ytd-popup-container//ytd-button-renderer");
    public void clickSubscribeButton() {
        SeleniumUtils.waitForAllElementsClickable(browser(), subscribeBtnPath, 60);
        WebElement subscribeButton = browser().findElement(subscribeBtnPath);
        if (subscribeButton.isDisplayed()){
            subscribeButton.click();
        }else {
            throw new NoSuchElementException("Subscribe button element not found " );
        }
    }

    public String getLoginText(){
        WebElement loginTextElement = SeleniumUtils.waitForElementVisible(browser(), signInTextPath, 30);
        return loginTextElement.getText();
    }

    public boolean isLoginDisplayed(){
        WebElement element = browser().findElement(signInTextPath);
        return Action.elementIsDisplayed(element);
    }
}
