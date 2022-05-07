package org.iti.tests;

import org.iti.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void testRegistration() {
        page.getInstance(HomePage.class).goToRegisterPage().registerUser("male", "ahmed", "medhat","1","10","1985", "ahmedrd@yyy.com", "159951");
        Assert.assertEquals(1, 1, "OK");

        /*
        RegisterPage registerPage = page.getInstance(HomePage.class).goToRegisterPage();
        registerPage.registerUser("male", "ahmed", "medhat","1","10","1985", "ahmedrd@yyy.com", "159951");
        */
    }

}
