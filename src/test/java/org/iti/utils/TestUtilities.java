package org.iti.utils;

import org.iti.tests.BaseTest;

public class TestUtilities extends BaseTest {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static int FAILED_COUNTER_FROM = 0;
    public static int NUM_OF_FAILED_RETRIES = 0;

    public void switchToFrame(String frame){
        driver.switchTo().frame(frame);
    }


}
