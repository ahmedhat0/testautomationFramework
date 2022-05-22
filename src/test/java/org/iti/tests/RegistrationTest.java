package org.iti.tests;

import org.iti.pages.LandingPage;
import org.iti.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.iti.utils.TestUtilities.getExcelData;

public class RegistrationTest extends BaseTest {

    @DataProvider(name = "excelDataProvider")
    public static Object[][] getData() throws IOException {
        String TESTDATA_SHEET_PATH = "src/test/resources/testData/testdata.xlsx";
        String SHEET_NAME = "RegistrationData";

        return getExcelData(TESTDATA_SHEET_PATH, SHEET_NAME);
    }

    @Test(dataProvider = "excelDataProvider")
    public void testRegistration(String gender, String firstName, String lastName, String day, String month,
                                 String year, String email, String password) {

        LandingPage landingPage = page.getInstance(LandingPage.class);
        RegisterPage registerPage = landingPage.goToRegisterPage();
        registerPage.registerUser(gender, firstName, lastName, day, month, year, email, password);
        String status = registerPage.getRegistrationStatus();

        Assert.assertEquals(status, "Your registration completed", "Register Error !");

    }


}
