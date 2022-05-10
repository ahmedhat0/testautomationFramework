package org.iti.utils;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Highlighter {
    static  String backgroundColor = "yellow";

    public static void highlightElement(@NotNull WebDriver driver, By element) {
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("arguments[0].setAttribute('style','background:"+ backgroundColor +";font-weight: bold;border: 2px solid black;');"
                , driver.findElement(element));
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        javascript.executeScript("arguments[0].setAttribute('style','border: solid 2px white');"
                , driver.findElement(element));
    }

}
