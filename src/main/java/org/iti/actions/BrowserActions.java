package org.iti.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.iti.utils.EventReporter;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BrowserActions {
    public EventFiringWebDriver driver;
    public UiActions uiActions;
    Logger logger = Logger.getLogger(BrowserActions.class);

    public void initDriver(String browser) {
        if (browser == null) browser = "edge";

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new EventFiringWebDriver(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new EventFiringWebDriver(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EventFiringWebDriver(new EdgeDriver());
                break;
        }
        
        driver.register(new EventReporter());
        driver.manage().window().setPosition(new Point(900, 0));
        driver.get("https://demo.nopcommerce.com/");
        logger.debug("Browser is opened");
        uiActions = new UiActions(driver);
    }

    public void closeDriver() {
        driver.quit();
    }
}
