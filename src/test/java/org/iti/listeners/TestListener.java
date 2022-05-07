package org.iti.listeners;

import org.iti.tests.BaseTest;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println((result.getTestName()).toUpperCase() + "Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println((result.getTestName()).toUpperCase() +"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println((result.getTestName()).toUpperCase() +"Test Failed");
        takeScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println((result.getTestName()).toUpperCase() +"Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished on : "+ context.getEndDate());
    }

}
