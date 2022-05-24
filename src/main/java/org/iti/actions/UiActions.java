package org.iti.actions;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    protected void selectItemInDropdownByVisibleText(By ByElement, String visibleText) {
        Select select = new Select(driver.findElement(ByElement));
        select.selectByVisibleText(visibleText);
    }

    protected void selectItemInDropdown(By ByElement, int index) {
        highlightElement(driver, ByElement);
        Select select = new Select(driver.findElement(ByElement));
        select.selectByIndex(index);
    }

    public void selectItemInDropdown(By ByElement, String value) {
        highlightElement(driver, ByElement);
        Select select = new Select(driver.findElement(ByElement));
        select.selectByValue(value);
    }

    public void clickOn(By ByElement) {
        highlightElement(driver, ByElement);
        driver.findElement(ByElement).click();
    }

    public void sendKeys(By ByElement, String text) {
        highlightElement(driver, ByElement);
        driver.findElement(ByElement).sendKeys(text);
    }

    protected void clear(By ByElement) {
        highlightElement(driver, ByElement);
        driver.findElement(ByElement).clear();
    }

    public String getText(By ByElement) {
        highlightElement(driver, ByElement);
        return driver.findElement(ByElement).getText();
    }

    protected WebElement getWebElement(By ByElement) {
        highlightElement(driver, ByElement);
        return driver.findElement(ByElement);
    }

    protected void mouseActions(@NotNull String actionNeeded, By ByElement) {
        highlightElement(driver, ByElement);
        Actions actions = new Actions(driver);
        switch (actionNeeded.toLowerCase()) {
            case "hover":
                actions.moveToElement(driver.findElement(ByElement)).build().perform();
                break;
            case "doubleclick":
                actions.doubleClick(driver.findElement(ByElement)).build().perform();
                break;
            case "rightclick":
                actions.contextClick(driver.findElement(ByElement)).build().perform();
                break;
        }
    }

    protected boolean isElement(By ByElement, @NotNull String actionNeeded) {
        switch (actionNeeded.toLowerCase()) {
            case "enabled":
                return driver.findElement(ByElement).isEnabled();
            case "selected":
                return driver.findElement(ByElement).isSelected();
            case "displayed":
                return driver.findElement(ByElement).isDisplayed();
        }
        return false;
    }

    protected void waitForElement(By ByElement, @NotNull String toBe, long timeOUTinMilliseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOUTinMilliseconds));
        switch (toBe.toLowerCase()) {
            case "visible":
                wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
                break;
            case "clickable":
                wait.until(ExpectedConditions.elementToBeClickable(ByElement));
                break;
        }
    }

    protected void pressKey(By ByElement, String key) {
        highlightElement(driver, ByElement);
        driver.findElement(ByElement).sendKeys(Keys.valueOf(key));
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
