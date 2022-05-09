package org.iti.utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;

import static org.iti.utils.TestUtilities.TESTDATA_SHEET_PATH;
import static org.iti.utils.TestUtilities.getExcelData;

public class DataProviderClass {

    @DataProvider(name = "excelDataProvider")
    public static Object[][] getData() throws IOException {
        return getExcelData(TESTDATA_SHEET_PATH, "RegistrationData");
    }

}
