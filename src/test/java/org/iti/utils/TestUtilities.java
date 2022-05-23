package org.iti.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.iti.actions.BrowserActions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtilities extends BrowserActions {

    public void switchToFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    public void takeScreenshot(String testMethodName) {
        System.out.println("Taking Screenshot ... ");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshots/" + testMethodName + ".png"));
        } catch (IOException e) {
            e.getCause();
        }
    }

}
