package org.iti.pages;

import com.epam.healenium.SelfHealingDriver;
import org.iti.actions.UiActions;
import org.iti.actions.UiActions.element;
import org.iti.utils.ReadProperties;
import org.openqa.selenium.By;

import static org.iti.actions.UiActions.element.CLICKABLE;
import static org.iti.actions.UiActions.element.VISIBLE;

public class RegisterPage {

    // * ********************************************************************************************************* * //
    // *                                         Registration Page Elements
    // * ********************************************************************************************************* * //

    private final By errorMsg = By.xpath("//*[contains(@class,'message-error')]");
    private final By successMsg = By.xpath(ReadProperties.getProperties("locators").getProperty("registrationPage.successMsg.xpath"));
    private final By logoutBtn = By.xpath("//a[contains(@class,'ico-logout')]");
    private final By maleRdBtn = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.maleRdBtn.id"));
    private final By femaleRdBtn = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.femaleRdBtn.id"));
    private final By firstNameBx = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.firstNameBx.id"));
    private final By lastNameBx = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.lastNameBx.id"));
    private final By dayOfBirth = By.name(ReadProperties.getProperties("locators").getProperty("registrationPage.dayOfBirth.name"));
    private final By monthOfBirth = By.name(ReadProperties.getProperties("locators").getProperty("registrationPage.monthOfBirth.name"));
    private final By yearOfBirth = By.name(ReadProperties.getProperties("locators").getProperty("registrationPage.yearOfBirth.name"));
    private final By emailBx = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.emailBx.id"));
    private final By passwordBx = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.passwordBx.id"));
    private final By confirmPasswordBx = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.confirmPasswordBx.id"));
    private final By registerBtn = By.xpath(ReadProperties.getProperties("locators").getProperty("registrationPage.registerBtn.xpath"));

    SelfHealingDriver driver;
    UiActions uiActions;

    public RegisterPage(SelfHealingDriver driver) {
        this.driver = driver;
        uiActions = new UiActions(driver);
    }

    // ? ********************************************************************************************************* ? //
    // ?                                        Registration Page Methods
    // ? ********************************************************************************************************* ? //

    public void registerUser(String gender, String firstname, String lastname, String day, String month, String year, String email, String password) {

        if (gender.equals("male")) uiActions.clickOn(maleRdBtn, element.CLICKABLE, 3000);
        else uiActions.clickOn(femaleRdBtn, element.CLICKABLE, 3000);

        uiActions.sendKeys(firstNameBx, firstname, element.CLICKABLE, 3000);
        uiActions.sendKeys(lastNameBx, lastname, element.CLICKABLE, 3000);

        /*
        uiActions.selectItemInDropdown(dayOfBirth, day, CLICKABLE, 3000);
        uiActions.selectItemInDropdown(monthOfBirth, month, CLICKABLE, 3000);
        uiActions.selectItemInDropdown(yearOfBirth, year, CLICKABLE, 3000);
*/

        uiActions.sendKeys(emailBx, email, element.CLICKABLE, 3000);

        uiActions.sendKeys(passwordBx, password, element.CLICKABLE, 3000);
        uiActions.sendKeys(confirmPasswordBx, password, element.CLICKABLE, 3000);

        uiActions.clickOn(registerBtn, element.CLICKABLE, 3000);
    }

    public String getRegistrationStatus() {
        return uiActions.getText(successMsg, element.VISIBLE, 3000);
    }

}
