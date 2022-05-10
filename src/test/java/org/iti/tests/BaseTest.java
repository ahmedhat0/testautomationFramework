package org.iti.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.iti.pages.BasePage;
import org.iti.pages.Page;
import org.iti.utils.EventReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public static EventFiringWebDriver driver;
    protected Page page;
    protected SoftAssert softAssert;
    Logger logger = Logger.getLogger(BaseTest.class);

    public static void takeScreenshot(String testMethodName) {
        System.out.println("Taking Screenshot ... ");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshots/" + testMethodName + ".png"));
        } catch (IOException e) {
            e.getCause();
        }
    }

    /**
     * IMPORTANT:
     */
    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional String browser) {

        /*
         ! ********************************************************************* !
         !                              IMPORTANT                                !
         ? Parametrization of the browser is not working here                    !
         ? it only works if run from the testng.xml file.                        !
         ! if the program fetch for the browser from here will get null          !
         ! so if its null use default @param chrome passed on the IF statement   !
         ! ********************************************************************* !
         */

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
        driver.manage().window().maximize();
        logger.debug("Browser is opened");
        page = new BasePage(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
