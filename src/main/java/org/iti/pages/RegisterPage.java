package org.iti.pages;

import org.iti.actions.UiActions;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends UiActions {

    // * ********************************************************************************************************* * //
    // *                                         Registration Page Elements
    // * ********************************************************************************************************* * //

    private final By errorMsg = By.xpath("//*[contains(@class,'message-error')]");
    private final By successMsg = By.xpath("//*[contains(@class,'result')][contains(text(),'completed')]");
    private final By logoutBtn = By.xpath("//a[contains(@class,'ico-logout')]");
    private final By maleRdBtn = By.id("gender-male");
    private final By femaleRdBtn = By.id("gender-female");
    private final By firstNameBx = By.id("FirstName");
    private final By lastNameBx = By.id("LastName");
    private final By dayOfBirth = By.name("DateOfBirthDay");
    private final By monthOfBirth = By.name("DateOfBirthMonth");
    private final By yearOfBirth = By.name("DateOfBirthYear");
    private final By emailBx = By.id("Email");
    private final By newsLetterCheck = By.id("Newsletter");
    private final By passwordBx = By.id("Password");
    private final By confirmPasswordBx = By.id("ConfirmPassword");
    private final By registerBtn = By.xpath("//button[contains(@class,'register')]");

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
