package org.iti.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.iti.utils.Highlighter.highlightElement;

public class UiActions {
    WebDriver driver;

    public UiActions(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement getWebElement(By ByElement, elementToBe toBe, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
        switch (toBe) {
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
                highlightElement(driver, ByElement);
                return driver.findElement(ByElement);
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(ByElement));
                highlightElement(driver, ByElement);
                return driver.findElement(ByElement);
            case enabled:
                wait.until(ExpectedConditions.elementToBeSelected(ByElement));
                highlightElement(driver, ByElement);
                return driver.findElement(ByElement);
            default:
                return null;
        }
    }

    public void clickOn(By ByElement, elementToBe toBe, int timeOut) {
        getWebElement(ByElement, toBe, timeOut).click();
    }

    public void sendKeys(By ByElement, String text, elementToBe toBe, int timeOut) {
        getWebElement(ByElement, toBe, timeOut).sendKeys(text);
    }

    public void clearAndSendKeys(By ByElement, String text, elementToBe toBe, int timeOut) {
        getWebElement(ByElement, toBe, timeOut).clear();
        sendKeys(ByElement, text, toBe, timeOut);
    }

    public String getText(By ByElement, elementToBe toBe, int timeOut) {
        return getWebElement(ByElement, toBe, timeOut).getText();
    }

    protected void selectItemInDropdown(By ByElement, elementToBe toBe, int timeOut, int index) {
        Select select = new Select(getWebElement(ByElement, toBe, timeOut));
        select.selectByIndex(index);
    }

    public void selectItemInDropdown(By ByElement, String value, elementToBe toBe, int timeOut) {
        Select select = new Select(getWebElement(ByElement, toBe, timeOut));
        select.selectByValue(value);
    }

    protected void selectItemInDropdownByVisibleText(By ByElement, elementToBe toBe, int timeOut, String visibleText) {
        Select select = new Select(getWebElement(ByElement, toBe, timeOut));
        select.selectByVisibleText(visibleText);
    }

    protected void mouseActions(mouseActions action, By ByElement, elementToBe toBe, int timeOut) {
        highlightElement(driver, ByElement);
        Actions actions = new Actions(driver);
        switch (action) {
            case hover:
                actions.moveToElement(getWebElement(ByElement, toBe, timeOut)).build().perform();
                break;
            case doubleclick:
                actions.doubleClick(getWebElement(ByElement, toBe, timeOut)).build().perform();
                break;
            case rightclick:
                actions.contextClick(getWebElement(ByElement, toBe, timeOut)).build().perform();
                break;
        }
    }


    public enum elementToBe {
        visible,
        clickable,
        enabled
    }

    public enum mouseActions {
        hover,
        doubleclick,
        rightclick
    }

    /*public <NeededPage extends UiActions> NeededPage getInstance(Class<NeededPage> pageNeeded) {
        try {
            return pageNeeded.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
