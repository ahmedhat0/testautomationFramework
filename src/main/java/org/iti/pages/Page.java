package org.iti.pages;

import org.apache.log4j.Logger;
import org.iti.utils.EventReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
    WebDriver driver;
    // ! ********************************************************************************************************* ! //
    // !                                             Page Constructor
    // ! ********************************************************************************************************* ! //
    public Page(WebDriver driver) {
        this.driver = driver;
    }
    // ! ********************************************************************************************************* ! //
    /**
    ! Abstract Methods
     */

    protected abstract void selectItemInDropdownByVisibleText(By ByElement, String visibleText);

    protected abstract void selectItemInDropdown(By ByElement, int index);

    protected abstract void selectItemInDropdown(By ByElement, String value);

    protected abstract void clickOn(By ByElement);

    protected abstract void mouseActions(String actionNeeded, By ByElement);

    protected abstract void sendKeys(By ByElement, String text);

    protected abstract void clear(By ByElement);

    protected abstract String getText(By ByElement);

    protected abstract boolean isElement(By ByElement, String actionNeeded);

    protected abstract WebElement getWebElement(By ByElement);

    protected abstract void waitForElement(By ByElement, String toBe, long timeOutInSeconds);

    /**
     * <h4>This is a generic type.</h4>
     * is used to create new Instance of any Page.
     * @param pageNeeded This is the name of the Page we want to create.
     * @return a constructor of the new Instance of the Page.
     */

    public <NeededPage extends BasePage> NeededPage getInstance(Class<NeededPage> pageNeeded) {
        try {
            return pageNeeded.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
