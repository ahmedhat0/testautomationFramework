package org.iti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    protected String linkXpath_format = "//*[contains(@class,'%s')]";

    // ************************************************************************************************************* //
    // *                                          Home Page Elements
    // ************************************************************************************************************* //

    private final By registerElement = By.xpath(String.format(linkXpath_format, "register"));
    private final By loginElement = By.xpath(String.format(linkXpath_format, "login"));
    private final By wishListElement = By.xpath(String.format(linkXpath_format, "wishlist"));
    private final By cartElement = By.xpath(String.format(linkXpath_format, "cart"));

    // ************************************************************************************************************* //
    // ************************************************************************************************************* //

    // ! ********************************************************************************************************* ! //
    // !                                        Home Page Constructor
    // ! ********************************************************************************************************* ! //
    public HomePage(WebDriver driver) {
        super(driver);
    }


    // ? ********************************************************************************************************* ? //
    // ?                                          Home Page Methods
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
