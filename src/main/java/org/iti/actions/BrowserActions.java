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
    public static ThreadLocal<WebDriver> mapper = new ThreadLocal<>();
    Logger logger = Logger.getLogger(BrowserActions.class);

    public WebDriver initDriver(String browser) {
        return initDriver(browser, headless.FALSE);
    }

    public WebDriver initDriver(String browserName, headless mode) {
        if (browserName == null) browserName = "chrome";
        if (mode == headless.TRUE) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    mapper.set(new ChromeDriver(options));
                    return getDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.setHeadless(true);
                    mapper.set(new FirefoxDriver(options1));
                    return getDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options2 = new EdgeOptions();
                    options2.setHeadless(true);
                    mapper.set(new EdgeDriver(options2));
                    return getDriver();
            }
        } else {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    mapper.set(new ChromeDriver());
                    return getDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    mapper.set(new FirefoxDriver());
                    return getDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    mapper.set(new EdgeDriver());
                    return getDriver();
            }
        }
        return null;
    }

    public static synchronized WebDriver getDriver() {
        return mapper.get();
    }

    public void navigateTo(String url) {
        getDriver().manage().window().setPosition(new Point(900, 0));
        getDriver().get(url);
        logger.debug("Browser is opened");
    }

    public void closeDriver() {
        getDriver().quit();
    }

    public enum headless {
        TRUE, FALSE
    }
}
