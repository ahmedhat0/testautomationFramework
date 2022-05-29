package org.iti.pages;

import com.epam.healenium.SelfHealingDriver;
import org.iti.actions.UiActions;

public class LoginPage {
    SelfHealingDriver driver;
    UiActions uiActions;

    public LoginPage(SelfHealingDriver driver) {
        this.driver = driver;
        uiActions = new UiActions(driver);
    }

    // ? ********************************************************************************************************* ? //
    // ?                                          Login Page Methods
    // ? ********************************************************************************************************* ? //


}
