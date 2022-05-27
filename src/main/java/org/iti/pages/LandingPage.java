package org.iti.pages;

import org.iti.actions.UiActions;
import org.iti.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.iti.actions.UiActions.element.CLICKABLE;


public class LandingPage {
    private final By registerElement = By.xpath(ReadProperties.getProperties("locators").getProperty("landingPage.registerElement.xpath"));
    private final By loginElement = By.xpath(ReadProperties.getProperties("locators").getProperty("landingPage.loginElement.xpath"));

    WebDriver driver;
    UiActions uiActions;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        uiActions = new UiActions(driver);
    }

    // ? ********************************************************************************************************* ? //
    // ?                                        Home Page Methods
    // ? ********************************************************************************************************* ? //

    public LoginPage goToLoginPage() {
        uiActions.clickOn(loginElement, CLICKABLE, 3000);
        return new LoginPage(driver);
    }

    public RegisterPage goToRegisterPage() {
        uiActions.clickOn(registerElement, CLICKABLE, 3000);
        return new RegisterPage(driver);
    }
}
