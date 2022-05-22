package org.iti.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.iti.actions.UiActions;
import org.iti.utils.EventReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public  EventFiringWebDriver driver;
    protected UiActions page;
    protected SoftAssert softAssert;
    Logger logger = Logger.getLogger(BaseTest.class);

    /**
     * IMPORTANT:
     */
    @BeforeTest
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {

        if (browser == null) browser = "chrome";

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
            default:
                System.out.println("Browser " + browser + " is not found ,Chrome is used");
                WebDriverManager.chromedriver().setup();
                driver = new EventFiringWebDriver(new ChromeDriver());
                break;
        }
        driver.register(new EventReporter());
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().setPosition(new Point(900,0));


        logger.debug("Browser is opened");

        page = new UiActions(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
