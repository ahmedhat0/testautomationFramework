package org.iti.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class EventReporter implements WebDriverEventListener {

    Logger logger = Logger.getLogger(EventReporter.class);

    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info("Trying to Navigating to:'" + url + "'");
//        System.out.println("Before navigating to: '" + url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info("Navigating to:'" + url + "'");
//        System.out.println("Navigated to:'" + url + "'");
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Trying to click on:'" + element.toString() + "'");
//        System.out.println("Trying to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("Clicked on:'" + element.toString() + "'");
//        System.out.println("Clicked on: " + element.toString());
    }

    public void beforeNavigateBack(WebDriver driver) {
        logger.warn("Navigating back to previous page");
//        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
        logger.warn("Navigated back to previous page");
//        System.out.println("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver) {
        logger.warn("Navigating forward to next page");
//        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
        logger.warn("Navigated forward to next page");
//        System.out.println("Navigated forward to next page");
    }


    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.warn("Trying to find element:'" + by.toString() + "'");
//        System.out.println("Trying to find Element  " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Found Element :'" + by.toString() + "'");
//        System.out.println("Found Element  " + by.toString());
    }

    public void beforeScript(String script, WebDriver driver) {
    }

    public void afterScript(String script, WebDriver driver) {
    }

    public void beforeAlertAccept(WebDriver driver) {

    }

    public void afterAlertAccept(WebDriver driver) {

    }

    public void afterAlertDismiss(WebDriver driver) {

    }

    public void beforeAlertDismiss(WebDriver driver) {

    }

    public void beforeNavigateRefresh(WebDriver driver) {

    }

    public void afterNavigateRefresh(WebDriver driver) {

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        logger.info("Trying to change value of:'" + element.toString() + "'");

//        System.out.println("Value of the:" + element.toString() + " before any changes made");
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        logger.info("Changed value of:'" + element.toString() + "'" + " to:'" + Arrays.toString(keysToSend) + "'");
//        System.out.println("Element value changed to: " + element.toString());
    }

    public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {

    }

    public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {

    }

    public void afterSwitchToWindow(String arg0, WebDriver arg1) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {

    }

    public void beforeGetText(WebElement arg0, WebDriver arg1) {

    }

    public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
    }
}
