package org.iti.pages;

import com.epam.healenium.SelfHealingDriver;
import org.iti.actions.UiActions;
import org.iti.actions.UiActions.element;
import org.openqa.selenium.By;

public class LoginPage {
    private final By EmailBx = By.id("Email");
    private final By PasswordBx = By.id("Password");
    private final By LoginBtn = By.xpath("//button[contains(@class,'login')]");

    SelfHealingDriver driver;
    UiActions uiActions;

    public LoginPage(SelfHealingDriver driver) {
        this.driver = driver;
        uiActions = new UiActions(driver);
    }

    public MyAccount loginUser(String email, String password) {
        uiActions.sendKeys(EmailBx, email, element.CLICKABLE, 1000);
        uiActions.sendKeys(PasswordBx, password, element.CLICKABLE, 1000);
        uiActions.clickOn(LoginBtn, element.CLICKABLE, 1000);
        return new MyAccount(driver);
    }

}
