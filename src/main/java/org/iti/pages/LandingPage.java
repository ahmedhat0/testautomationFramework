package org.iti.pages;

import org.iti.actions.UiActions;
import org.iti.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends UiActions {
    public LandingPage(WebDriver driver) {
        super(driver);
    }
//    protected String linkXpath_format = "//*[contains(@class,'%s')]";

    private final By registerElement = By.xpath(ReadProperties.getProperties("locators").getProperty("landingPage.registerElement.xpath"));
    private final By loginElement = By.xpath(ReadProperties.getProperties("locators").getProperty("landingPage.loginElement.xpath"));

//    private final By wishListElement = By.xpath(String.format(linkXpath_format, "wishlist"));
//    private final By cartElement = By.xpath(String.format(linkXpath_format, "cart"));

    // ? ********************************************************************************************************* ? //
    // ?                                        Home Page Methods
    // ? ********************************************************************************************************* ? //

    public LoginPage goToLoginPage() {
        clickOn(loginElement);
        return getInstance(LoginPage.class);
    }

    public RegisterPage goToRegisterPage() {
        clickOn(registerElement);
        return getInstance(RegisterPage.class);
    }
}
