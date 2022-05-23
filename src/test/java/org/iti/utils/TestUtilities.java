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

    static FileInputStream sourceExcelIs = null;

    public static FileInputStream LoadExcelFile(String path) throws FileNotFoundException {
        File source = new File(path);
        sourceExcelIs = new FileInputStream(source);
        return sourceExcelIs;
    }

    public static Object[][] getExcelData(String path, String sheetName) throws IOException {
        sourceExcelIs = LoadExcelFile(path);
        XSSFWorkbook workbook = new XSSFWorkbook(sourceExcelIs);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int totalNumberOfRows = (sheet.getLastRowNum() + 1);
        int totalNumberOfCols = sheet.getRow(0).getLastCellNum();
//        System.out.println(totalNumberOfCols);
        String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfCols];

        for (int r = 0; r < totalNumberOfRows; r++) {
            for (int c = 0; c < totalNumberOfCols; c++) {
                XSSFRow row = sheet.getRow(r);
                arrayExcelData[r][c] = row.getCell(c).toString();
            }
        }
        workbook.close();
        return arrayExcelData;
    }


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
