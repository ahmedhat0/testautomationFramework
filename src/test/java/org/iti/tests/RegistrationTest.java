package org.iti.tests;

import org.iti.actions.BrowserActions;
import org.iti.pages.LandingPage;
import org.iti.pages.RegisterPage;
import org.iti.utils.ProviderClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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

    @Test(dataProvider = "registrationProvider", dataProviderClass = ProviderClass.class)
    public void testRegistration(String gender, String firstName, String lastName, String day, String month,
                                 String year, String email, String password) {

        LandingPage landingPage = new LandingPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        landingPage.goToRegisterPage();
        registerPage.registerUser(gender, firstName, lastName, day, month, year, email, password);
        assertEquals(registerPage.getRegistrationStatus(), "Your registration completed", "Register Error !");
    }

}
