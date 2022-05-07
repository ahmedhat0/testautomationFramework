package org.iti.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.iti.pages.BasePage;
import org.iti.pages.Page;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    public static WebDriver driver;
    protected Page page;
    protected SoftAssert softAssert;

    /**
     * IMPORTANT:
     */
    @BeforeMethod
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
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser " + browser + " is not found ,Chrome is used");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static void takeScreenshot(String testMethodName) {
        System.out.println("Taking Screenshot ... ");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            DateFormat obj = new SimpleDateFormat("ddMMMyyyy-HH:mm:ss");
            String date = obj.format(new Date(System.currentTimeMillis()));
            FileUtils.copyFile(scrFile, new File("screenshots/" + testMethodName + ".png"));
        } catch (IOException e) {
            e.getCause();
        }
    }
}
