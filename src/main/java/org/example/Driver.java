package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Driver {
    private static WebDriver driver;

    public static WebDriver browser() {
        if (driver == null) {
            try {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } catch (Exception e) {
                System.err.println("Error initializing WebDriver: " + e.getMessage());
                throw new RuntimeException("WebDriver initialization failed", e);
            }
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
