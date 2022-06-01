package org.iti.pages;

import com.epam.healenium.SelfHealingDriver;
import org.iti.actions.UiActions;
import org.iti.actions.UiActions.element;
import org.openqa.selenium.By;

public class MyAccount {
    private final By LogoutBtn = By.className("ico-logout");
    SelfHealingDriver driver;
    UiActions uiActions;

    public MyAccount(SelfHealingDriver driver) {
        this.driver = driver;
        uiActions = new UiActions(driver);
    }

    public boolean getLoginStatus() {
        return uiActions.isElementPresent(LogoutBtn, element.VISIBLE, 1000);
    }

    public void logOut() {
        uiActions.clickOn(LogoutBtn, element.CLICKABLE, 1000);
    }


}
