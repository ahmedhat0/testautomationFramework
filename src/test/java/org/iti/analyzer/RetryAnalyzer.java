package org.iti.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.iti.utils.TestUtilities.FAILED_COUNTER_FROM;
import static org.iti.utils.TestUtilities.NUM_OF_FAILED_RETRIES;

public class RetryAnalyzer implements IRetryAnalyzer {

    int count = FAILED_COUNTER_FROM;
    int maxTry = NUM_OF_FAILED_RETRIES;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxTry) {
            count++;
            return true;
        }
        return false;
    }
}

