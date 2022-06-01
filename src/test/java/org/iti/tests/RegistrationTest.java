package org.iti.tests;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.annotation.DisableHealing;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional String browser) {
        driver = browserActions.initDriver(browser, headless.FALSE);
        browserActions.navigateTo(url);
    }

    @AfterClass
    public void closeDriver() {
        browserActions.closeDriver();
    }

    @Test(dataProvider = "registrationProvider", dataProviderClass = ProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that user can register successfully")
    @Link(name = "My Linkedin", url = "https://www.linkedin.com/in/amedhat/")
    @DisableHealing
    public void testRegistration(String gender,
                                 String firstName,
                                 String lastName,
                                 String day,
                                 String month,
                                 String year,
                                 String email,
                                 String password) {

        landingPage = new LandingPage(driver);

        registerPage = landingPage.goToRegisterPage();
        registerPage.registerUser(gender, firstName, lastName, day, month, year, email, password);
        assertEquals(registerPage.getRegistrationStatus(), "Your registration completed");
    }

}
