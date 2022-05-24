package org.iti.tests;

import org.iti.actions.BrowserActions;
import org.iti.pages.LandingPage;
import org.iti.pages.RegisterPage;
import org.iti.utils.Reader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class RegistrationTest {
    WebDriver driver;
    BrowserActions browserActions = new BrowserActions();
    String url = "https://demo.nopcommerce.com/";
    @BeforeTest
    @Parameters({"browser"})
    public void setUp(@Optional String browser) {
        driver = browserActions.initDriver(browser);
        browserActions.navigateTo(url);
    }

    @AfterTest
    public void closeDriver() {
        browserActions.closeDriver();
    }

    @DataProvider(name = "excelDataProvider")
    public static Object[][] getData() throws IOException {
        String TESTDATA_SHEET_PATH = "src/test/resources/testData/testdata.xlsx";
        String SHEET_NAME = "RegistrationData";
        return Reader.getExcelData(TESTDATA_SHEET_PATH, SHEET_NAME);
    }

    @Test(dataProvider = "excelDataProvider")
    public void testRegistration(String gender, String firstName, String lastName, String day, String month,
                                 String year, String email, String password) {

        LandingPage landingPage = new LandingPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        landingPage.goToRegisterPage();
        registerPage.registerUser(gender, firstName, lastName, day, month, year, email, password);
        String status = registerPage.getRegistrationStatus();

        assertEquals(status, "Your registration completed", "Register Error !");
    }

}
