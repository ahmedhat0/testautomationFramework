package org.iti.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {
    static FileInputStream fis = null;

    public static FileInputStream LoadExcelFile(String path) throws FileNotFoundException {
        File source = new File(path);
        fis = new FileInputStream(source);
        return fis;
    }

    public static Object[][] getExcelData(String path, String sheetName) throws IOException {

        fis = LoadExcelFile(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int totalNumberOfRows = (sheet.getLastRowNum() + 1);
        int totalNumberOfCols = sheet.getRow(0).getLastCellNum();

        String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfCols];
        for (int r = 0; r < totalNumberOfRows; r++) {
            System.out.println(totalNumberOfRows + ",,,,,,,,,,,,,," + totalNumberOfCols);

            for (int c = 0; c < totalNumberOfCols; c++) {
                System.out.println(r + "," + c);
                XSSFRow row = sheet.getRow(r);
                arrayExcelData[r][c] = row.getCell(c).toString();
            }
        }
        workbook.close();
        return arrayExcelData;
    }


}
