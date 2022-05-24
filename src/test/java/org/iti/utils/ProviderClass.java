package org.iti.utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ProviderClass {

    @DataProvider(name = "registrationProvider")
    public static Object[][] getRegistrationData() throws IOException {
        String TESTDATA_SHEET_PATH = "src/test/resources/testData/testdata.xlsx";
        String SHEET_NAME = "RegistrationData";
        return Reader.getExcelData(TESTDATA_SHEET_PATH, SHEET_NAME);
    }

    @DataProvider(name = "loginProvider")
    public static Object[][] getLoginData() throws IOException {
        String TESTDATA_SHEET_PATH = "src/test/resources/testData/testdata.xlsx";
        String SHEET_NAME = "LoginData";
        return Reader.getExcelData(TESTDATA_SHEET_PATH, SHEET_NAME);
    }
}
