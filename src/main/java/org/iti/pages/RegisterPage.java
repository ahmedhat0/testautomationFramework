package org.iti.pages;

import org.iti.actions.UiActions;
import org.iti.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends UiActions {

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

    // * ********************************************************************************************************* * //
    // * ********************************************************************************************************* * //

    // ! ********************************************************************************************************* ! //
    // !                                        Registration Page Constructor
    // ! ********************************************************************************************************* ! //

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // ? ********************************************************************************************************* ? //
    // ?                                        Registration Page Methods
    // ? ********************************************************************************************************* ? //

    public void registerUser(String gender,
                             String firstname,
                             String lastname,
                             String day,
                             String month,
                             String year,
                             String email,
                             String password) {

        if (gender.equals("male")) clickOn(maleRdBtn);
        else clickOn(femaleRdBtn);

        sendKeys(firstNameBx, firstname);
        sendKeys(lastNameBx, lastname);

        selectItemInDropdown(dayOfBirth, day);
        selectItemInDropdown(monthOfBirth, month);
        selectItemInDropdown(yearOfBirth, year);

        sendKeys(emailBx, email);

        sendKeys(passwordBx, password);
        sendKeys(confirmPasswordBx, password);

        clickOn(registerBtn);
    }

    public String getRegistrationStatus() {
        return getText(successMsg);
    }

}
