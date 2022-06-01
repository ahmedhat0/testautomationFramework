package org.iti.actions;

import com.epam.healenium.SelfHealingDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.iti.utils.Highlighter.highlightElement;

public class UiActions {
    SelfHealingDriver driver;

    public UiActions(SelfHealingDriver driver) {
        this.driver = driver;
    }

    public WebElement getWebElement(By ByElement, @NotNull element toBe, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        switch (toBe) {

            case VISIBLE:
                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
                } catch (Exception e) {
                    System.out.println("Element " + ByElement.toString() + " is not visible");
                }
                js.executeScript("arguments[0].scrollIntoView();", driver.findElement(ByElement));
                highlightElement(driver, ByElement);
                return driver.findElement(ByElement);
            case CLICKABLE:
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(ByElement));
                } catch (Exception e) {
                    System.out.println("Element " + ByElement.toString() + " is not clickable");
                }
                js.executeScript("arguments[0].scrollIntoView();", driver.findElement(ByElement));
                highlightElement(driver, ByElement);
                return driver.findElement(ByElement);
            case ENABLED:
                try {
                    wait.until(ExpectedConditions.elementToBeSelected(ByElement));
                } catch (Exception e) {
                    System.out.println("Element " + ByElement.toString() + " is not enabled");
                }
                js.executeScript("arguments[0].scrollIntoView();", driver.findElement(ByElement));
                highlightElement(driver, ByElement);
                return driver.findElement(ByElement);
            default:
                return null;
        }
    }

    public void clickOn(By ByElement, element toBe, int timeOut) {
        getWebElement(ByElement, toBe, timeOut).click();
    }

    public void sendKeys(By ByElement, String text, element toBe, int timeOut) {
        getWebElement(ByElement, toBe, timeOut).sendKeys(text);
    }

    public void clearAndSendKeys(By ByElement, String text, element toBe, int timeOut) {
        getWebElement(ByElement, toBe, timeOut).clear();
        sendKeys(ByElement, text, toBe, timeOut);
    }

    public String getText(By ByElement, element toBe, int timeOut) {
        return getWebElement(ByElement, toBe, timeOut).getText();
    }

    public void selectItemInDropdown(By ByElement, element toBe, int timeOut, int index) {
        Select select = new Select(getWebElement(ByElement, toBe, timeOut));
        select.selectByIndex(index);
    }

    public void selectItemInDropdown(By ByElement, String value, element toBe, int timeOut) {
        Select select = new Select(getWebElement(ByElement, toBe, timeOut));
        select.selectByValue(value);
    }

    public void selectItemInDropdownByVisibleText(By ByElement, element toBe, int timeOut, String visibleText) {
        Select select = new Select(getWebElement(ByElement, toBe, timeOut));
        select.selectByVisibleText(visibleText);
    }

    public void mouseActions(mouse action, By ByElement, element toBe, int timeOut) {
        highlightElement(driver, ByElement);
        Actions actions = new Actions(driver);
        switch (action) {
            case HOVER:
                actions.moveToElement(getWebElement(ByElement, toBe, timeOut)).build().perform();
                break;
            case DOUBLECLICK:
                actions.doubleClick(getWebElement(ByElement, toBe, timeOut)).build().perform();
                break;
            case RIGHTCLICK:
                actions.contextClick(getWebElement(ByElement, toBe, timeOut)).build().perform();
                break;
        }
    }

    public boolean isElementPresent(By ByElement, element toBe, int timeOut) {
        try {
            getWebElement(ByElement, toBe, timeOut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public enum element {
        VISIBLE, CLICKABLE, ENABLED
    }

    public enum mouse {
        HOVER, DOUBLECLICK, RIGHTCLICK
    }
}
