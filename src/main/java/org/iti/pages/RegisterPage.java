package org.iti.pages;

import org.iti.actions.UiActions;
import org.iti.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private final By newsLetterCheck = By.id("Newsletter");
    private final By passwordBx = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.passwordBx.id"));
    private final By confirmPasswordBx = By.id(ReadProperties.getProperties("locators").getProperty("registrationPage.confirmPasswordBx.id"));
    private final By registerBtn = By.xpath(ReadProperties.getProperties("locators").getProperty("registrationPage.registerBtn.xpath"));

    WebDriver driver;
    UiActions uiActions;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        uiActions = new UiActions(driver);
    }

    // ? ********************************************************************************************************* ? //
    // ?                                        Registration Page Methods
    // ? ********************************************************************************************************* ? //

    public void registerUser(String gender, String firstname, String lastname, String day, String month, String year, String email, String password) {

        if (gender.equals("male")) uiActions.clickOn(maleRdBtn);
        else uiActions.clickOn(femaleRdBtn);

        uiActions.sendKeys(firstNameBx, firstname);
        uiActions.sendKeys(lastNameBx, lastname);

        uiActions.selectItemInDropdown(dayOfBirth, day);
        uiActions.selectItemInDropdown(monthOfBirth, month);
        uiActions.selectItemInDropdown(yearOfBirth, year);

        uiActions.sendKeys(emailBx, email);

        uiActions.sendKeys(passwordBx, password);
        uiActions.sendKeys(confirmPasswordBx, password);

        uiActions.clickOn(registerBtn);
    }

    public String getRegistrationStatus() {
        return uiActions.getText(successMsg);
    }

}
