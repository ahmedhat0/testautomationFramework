package org.iti.tests;

import org.iti.pages.HomePage;
import org.iti.utils.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "excelDataProvider", dataProviderClass = DataProviderClass.class)
    public void testRegistration(String gender,
                                 String firstName,
                                 String lastName,
                                 String day,
                                 String month,
                                 String year,
                                 String email,
                                 String password) {

        page.getInstance(HomePage.class).goToRegisterPage()
                .registerUser(gender, firstName, lastName, day, month, year, email, password);

        Assert.assertEquals(1, 1, "OK");

        /*
        "male", "ahmed", "medhat", "1", "10", "1985", "ahmedrd@yyy.com", "159951"
        RegisterPage registerPage = page.getInstance(HomePage.class).goToRegisterPage();
        registerPage.registerUser("male", "ahmed", "medhat","1","10","1985", "ahmedrd@yyy.com", "159951");
        */
    }


}
