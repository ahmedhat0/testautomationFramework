package org.iti.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

    public WebDriver initDriver(String browser, boolean setHeadless) {
        if (browser == null) browser = "chrome";

        if (setHeadless) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driver = new ChromeDriver(options);
                    return driver;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.setHeadless(true);
                    driver = new FirefoxDriver(options1);
                    return driver;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options2 = new EdgeOptions();
                    options2.setHeadless(true);
                    driver = new EdgeDriver(options2);
                    return driver;
            }
        } else {
            return initDriver(browser);
        }
        return null;
    }

    public void navigateTo(String url) {
        driver.manage().window().setPosition(new Point(900, 0));
        driver.get(url);
        logger.debug("Browser is opened");
    }

    public void closeDriver() {
        driver.quit();
    }
}
