package org.iti.actions;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserActions {
    public static ThreadLocal<SelfHealingDriver> mapper = new ThreadLocal<>();
    Logger logger = Logger.getLogger(BrowserActions.class);

    public static synchronized SelfHealingDriver getDriver() {
        return mapper.get();
    }

    public SelfHealingDriver initDriver(String browser) {
        return initDriver(browser, headless.FALSE);
    }

    public SelfHealingDriver initDriver(String browserName, headless mode) {
        if (browserName == null) browserName = "chrome";
        if (mode == headless.TRUE) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    mapper.set(SelfHealingDriver.create(new ChromeDriver(options)));
                    return getDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.setHeadless(true);
                    mapper.set(SelfHealingDriver.create(new FirefoxDriver(options1)));
                    return getDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options2 = new EdgeOptions();
                    options2.setHeadless(true);
                    mapper.set(SelfHealingDriver.create(new EdgeDriver(options2)));
                    return getDriver();
            }
        } else {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    mapper.set(SelfHealingDriver.create(new ChromeDriver()));
                    return getDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    mapper.set(SelfHealingDriver.create(new FirefoxDriver()));
                    return getDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    mapper.set(SelfHealingDriver.create(new EdgeDriver()));
                    return getDriver();
            }
        }
        return null;
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
