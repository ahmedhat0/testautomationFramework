package org.iti.pages;

import com.epam.healenium.SelfHealingDriver;
import org.iti.actions.UiActions;
import org.iti.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.iti.actions.UiActions.element.CLICKABLE;


public class LandingPage {
    private final By registerElement = By.xpath(ReadProperties.getProperties("locators").getProperty("landingPage.registerElement.xpath"));
    private final By loginElement = By.xpath(ReadProperties.getProperties("locators").getProperty("landingPage.loginElement.xpath"));

    SelfHealingDriver driver;
    UiActions uiActions;

    public LandingPage(SelfHealingDriver driver) {
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

    public RegisterPage goToRegisterPage() throws InterruptedException {
        Thread.sleep(10000);
        uiActions.clickOn(registerElement, CLICKABLE, 3000);
        return new RegisterPage(driver);
    }
}
