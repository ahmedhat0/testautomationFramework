package org.iti.steps;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.iti.actions.BrowserActions;
import org.iti.pages.LandingPage;
import org.iti.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;


public class RegistrationStory {
    SelfHealingDriver driver;
    BrowserActions browserActions = new BrowserActions();
    private RegisterPage registrationPage;
    private LandingPage landingPage;
    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() {
        driver = browserActions.initDriver("firefox");
        registrationPage = new RegisterPage(driver);
        landingPage = new LandingPage(driver);
        browserActions.navigateTo("https://demo.nopcommerce.com/");
    }

    @When("^I click on the register link$")
    public void i_click_on_the_register_link() {
        landingPage.goToRegisterPage();

    }

    @When("^I fill in the registration form$")
    public void i_fill_in_the_registration_form() {
        registrationPage.registerUser("male", "ahmed", "medhat", "1", "10", "1990", "ahmed.medhat@cucumber.test", "159951");
    }


    @Then("^I should see the registration success message$")
    public void i_should_see_the_registration_success_message() {
        assertEquals(registrationPage.getRegistrationStatus(), "Your registration completed");
        browserActions.closeDriver();
    }
}

