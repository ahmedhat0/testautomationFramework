package org.iti.utils;

import org.iti.tests.BaseTest;

import java.util.ArrayList;

public class TestUtilities extends BaseTest {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static int FAILED_COUNTER_FROM = 0;
    public static int NUM_OF_FAILED_RETRIES = 0;

    public static String TESTDATA_SHEET_PATH = "src/test/java/org/iti/testData/TestData.xlsx";

    static Xls_Reader reader;
    public void switchToFrame(String frame){
        driver.switchTo().frame(frame);
    }

/*
    public static ArrayList<Object[]> getDataFromExcel(){
        ArrayList<Object[]> data = new ArrayList<Object[]>();

        reader = new Xls_Reader(TESTDATA_SHEET_PATH);

        for (int rowNum = 2 ; rowNum <= reader.getRowCount("RegistrationData") ; rowNum++){

            String gender = reader.getCellData("RegistrationData", "gender", rowNum);
            String firstName = reader.getCellData("RegistrationData", "firstname", rowNum);
            String lastName = reader.getCellData("RegistrationData", "lastname", rowNum);
            String day = reader.getCellData("RegistrationData", "dayOfBirth", rowNum);
            String month = reader.getCellData("RegistrationData", "monthOfBirth", rowNum);
            String year = reader.getCellData("RegistrationData", "yearOfBirth", rowNum);

            Object ob[] = {gender,firstName,lastName,day,month,year};
            data.add(ob);
        }
        return data;
    }
*/




}
