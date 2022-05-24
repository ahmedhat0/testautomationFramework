package org.iti.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions {
    public WebDriver driver;
    Logger logger = Logger.getLogger(BrowserActions.class);

    public WebDriver initDriver(String browser) {
        if (browser == null) browser = "chrome";

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                return driver;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                return driver;
        }
        return null;
    }

    public void getUrl() {
        driver.get("https://demo.nopcommerce.com/");
        logger.debug("Browser is opened");
    }

    public void closeDriver() {
        driver.quit();
    }
}
