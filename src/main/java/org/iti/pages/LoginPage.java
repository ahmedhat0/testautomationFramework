package org.iti.pages;

import org.iti.actions.UiActions;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    UiActions uiActions;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        uiActions = new UiActions(driver);
    }

    // ? ********************************************************************************************************* ? //
    // ?                                          Login Page Methods
    // ? ********************************************************************************************************* ? //


}
