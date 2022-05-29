package org.iti.tests;

import com.epam.healenium.SelfHealingDriver;
import org.iti.actions.BrowserActions;
import org.iti.actions.BrowserActions.headless;
import org.iti.pages.LandingPage;
import org.iti.pages.RegisterPage;
import org.iti.utils.ProviderClass;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class RegistrationTest {
    SelfHealingDriver driver;
    LandingPage landingPage;
    RegisterPage registerPage;
    BrowserActions browserActions = new BrowserActions();
    String url = "https://demo.nopcommerce.com/";

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(@Optional String browser) {
        driver = browserActions.initDriver(browser, headless.FALSE);
        browserActions.navigateTo(url);
    }

    @AfterTest
    public void closeDriver() {
        browserActions.closeDriver();
    }

    @Test(dataProvider = "registrationProvider", dataProviderClass = ProviderClass.class)
    public void testRegistration(String gender, String firstName, String lastName, String day, String month, String year, String email, String password) throws InterruptedException {

        landingPage = new LandingPage(driver);
        registerPage = new RegisterPage(driver);

        landingPage.goToRegisterPage();
        registerPage.registerUser(gender, firstName, lastName, day, month, year, email, password);
        assertEquals(registerPage.getRegistrationStatus(), "Your registration completed");
    }

}
