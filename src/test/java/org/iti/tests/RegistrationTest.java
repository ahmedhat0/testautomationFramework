package org.iti.tests;

import org.iti.actions.BrowserActions;
import org.iti.pages.LandingPage;
import org.iti.pages.RegisterPage;
import org.iti.utils.Reader;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class RegistrationTest {
    BrowserActions browserActions = new BrowserActions();

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(@Optional String browser){
        browserActions.initDriver(browser);
    }

    @AfterTest
    public void closeDriver(){
        browserActions.closeDriver();
    }

    @DataProvider(name = "excelDataProvider")
    public static Object[][] getData() throws IOException {
        String TESTDATA_SHEET_PATH = "src/test/resources/testData/testdata.xlsx";
        String SHEET_NAME = "RegistrationData";
        return Reader.getExcelData(TESTDATA_SHEET_PATH,SHEET_NAME);
    }


    @Test(dataProvider = "excelDataProvider")
    public void testRegistration(String gender, String firstName, String lastName, String day, String month,
                                 String year, String email, String password) {

        LandingPage landingPage = browserActions.uiActions.getInstance(LandingPage.class);
        RegisterPage registerPage = landingPage.goToRegisterPage();
        registerPage.registerUser(gender, firstName, lastName, day, month, year, email, password);
        String status = registerPage.getRegistrationStatus();

        Assert.assertEquals(status, "Your registration completed", "Register Error !");
    }

}
