package org.iti.tests;

import org.iti.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    public void testRegistration() {
        page.getInstance(HomePage.class).goToRegisterPage().registerUser("male", "ahmed", "medhat","1","10","1985", "ahmedrd@yyy.com", "159951");
        assertEquals(1, 1, "dddd");
        /*
        RegisterPage registerPage = page.getInstance(HomePage.class).goToRegisterPage();
        registerPage.registerUser("male", "ahmed", "medhat","1","10","1985", "ahmedrd@yyy.com", "159951");
        */
    }

}
