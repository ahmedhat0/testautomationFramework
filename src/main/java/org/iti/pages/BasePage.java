package org.iti.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.iti.utils.Highlighter.highlightElement;

import java.time.Duration;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void selectItemInDropdownByVisibleText(By ByElement, String visibleText) {
        Select select = new Select(driver.findElement(ByElement));
        select.selectByVisibleText(visibleText);
    }

    @Override
    protected void selectItemInDropdown(By ByElement, int index) {
        highlightElement(driver, ByElement);
        Select select = new Select(driver.findElement(ByElement));
        select.selectByIndex(index);
    }

    @Override
    protected void selectItemInDropdown(By ByElement, String value) {
        highlightElement(driver, ByElement);
        Select select = new Select(driver.findElement(ByElement));
        select.selectByValue(value);
    }

    @Override
    protected void clickOn(By ByElement) {
        highlightElement(driver, ByElement);
        driver.findElement(ByElement).click();
    }

    @Override
    protected void sendKeys(By ByElement, String text) {
        highlightElement(driver, ByElement);
        driver.findElement(ByElement).sendKeys(text);
    }

    @Override
    protected void clear(By ByElement) {
        highlightElement(driver, ByElement);
        driver.findElement(ByElement).clear();
    }

    @Override
    protected String getText(By ByElement) {
        highlightElement(driver, ByElement);
        return driver.findElement(ByElement).getText();
    }

    @Override
    protected WebElement getWebElement(By ByElement) {
        highlightElement(driver, ByElement);
        return driver.findElement(ByElement);
    }

    @Override
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

    @Override
    protected boolean isElement(By ByElement, @NotNull String actionNeeded) {
        switch (actionNeeded.toLowerCase()) {
            case "enabled":
                return driver.findElement(ByElement).isEnabled();
            case "selected":
                return driver.findElement(ByElement).isSelected();
            default:
                return driver.findElement(ByElement).isDisplayed();
        }
    }

    @Override
    protected void waitForElement(By ByElement, @NotNull String toBe, long timeOUTinMilliseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOUTinMilliseconds));
        switch (toBe.toLowerCase()) {
            case "visible":
                wait.until(ExpectedConditions
                        .visibilityOfElementLocated(ByElement));
                break;
            case "clickable":
                wait.until(ExpectedConditions
                        .elementToBeClickable(ByElement));
                break;
        }
    }

}
