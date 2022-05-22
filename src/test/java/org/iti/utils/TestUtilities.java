package org.iti.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.iti.tests.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtilities extends BaseTest {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static String TESTDATA_SHEET_PATH =  "src/test/java/org/iti/testData/testdata.xlsx";

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

}
