package org.iti.pages;

import org.iti.actions.UiActions;
import org.iti.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends UiActions {
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    private final By registerBtn = By.xpath(ReadProperties.getProperties("locators.properties").getProperty("landingPage.registerBtn.xpath"));
    private final By loginBtn = By.xpath(ReadProperties.getProperties("locators.properties").getProperty("landingPage.loginBtn.xpath"));

//    protected String linkXpath_format = "//*[contains(@class,'%s')]";
//    private final By wishListElement = By.xpath(String.format(linkXpath_format, "wishlist"));
//    private final By cartElement = By.xpath(String.format(linkXpath_format, "cart"));

    // ? ********************************************************************************************************* ? //
    // ?                                        Home Page Methods
    // ? ********************************************************************************************************* ? //

    public LoginPage goToLoginPage() {
        clickOn(loginBtn);
        return getInstance(LoginPage.class);
    }

    public RegisterPage goToRegisterPage() {
        clickOn(registerBtn);
        return getInstance(RegisterPage.class);
    }
}
