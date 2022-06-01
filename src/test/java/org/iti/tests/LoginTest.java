package org.iti.tests;

import com.epam.healenium.SelfHealingDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.iti.actions.BrowserActions;
import org.iti.actions.BrowserActions.headless;
import org.iti.pages.LandingPage;
import org.iti.pages.LoginPage;
import org.iti.pages.MyAccount;
import org.iti.utils.ProviderClass;
import org.iti.utils.RetryFailed;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    SelfHealingDriver driver;
    BrowserActions browserActions = new BrowserActions();
    LandingPage landingPage;
    LoginPage loginPage;
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

    @Test(dataProvider = "loginProvider",
            dataProviderClass = ProviderClass.class,
            retryAnalyzer = RetryFailed.class)

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that user can login successfully")

    public void testLogin(String email, String password) {

        landingPage = new LandingPage(driver);
        loginPage = landingPage.goToLoginPage();
        MyAccount myAccount = loginPage.loginUser(email, password);
        assertTrue(myAccount.getLoginStatus(), "User Didn't Login Successfully");
        if (!myAccount.getLoginStatus()) {
            myAccount.logOut();
        }
    }


}
