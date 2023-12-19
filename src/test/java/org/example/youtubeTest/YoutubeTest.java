package org.example.youtubeTest;

import org.example.Driver;
import org.example.config.Config;
import org.example.page.AccountPage;
import org.example.page.WatchPage;
import org.example.page.ResultSearchPage;
import org.example.page.YoutubeStartPage;
import org.example.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.example.Driver.browser;

public class YoutubeTest {
    private YoutubeStartPage youtubeStartPage;
    @BeforeClass
    private void setUp(){
        browser().get(Config.BASE_URL);
        youtubeStartPage = new YoutubeStartPage();
    }

    @Test(priority = 0)
    public void verifyPageTitle() {
        String actualTitle = browser().getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match the expected value.");
    }

    @Test(priority = 1)
    public void searchAndSelectVideo() {
        String searchQuery = Utils.generateRandomNumber();
        youtubeStartPage.setText(searchQuery);

        ResultSearchPage resultSearchPage = youtubeStartPage.clickOnItemResultByIndex(2);
        WatchPage watchPage = resultSearchPage.clickOnVideoByIndex(4);
        AccountPage accountPage = watchPage.clickOnAvatar();

        accountPage.clickSubscribeButton();
        String actualButtonText = accountPage.getLoginText();
        String expectedButtonText = "Sign in";
        Assert.assertEquals(actualButtonText, expectedButtonText, "Button text does not match the expected value.");
    }

    @AfterClass
    public void tearDown() {
        Driver.quit();
    }
}
