package org.iti.pages.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.iti.pages.BasePage;
import org.iti.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected Page page;
    protected SoftAssert softAssert;
    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        browser = browser.toLowerCase();
        switch (browser) {
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
}
