package org.iti.pages;

import org.iti.actions.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends UiActions {

    protected String linkXpath_format = "//*[contains(@class,'%s')]";

    private final By registerElement = By.xpath(String.format(linkXpath_format, "register"));
    private final By loginElement = By.xpath(String.format(linkXpath_format, "login"));
    private final By wishListElement = By.xpath(String.format(linkXpath_format, "wishlist"));
    private final By cartElement = By.xpath(String.format(linkXpath_format, "cart"));

    // ************************************************************************************************************* //
    // ************************************************************************************************************* //

    public LandingPage(WebDriver driver) {
        super(driver);
    }

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
