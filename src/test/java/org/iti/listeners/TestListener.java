package org.iti.listeners;

import org.iti.tests.BaseTest;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
    // result.getMethod().getMethodName()
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed");
    }

    @Override
    public void onTestFailure(@NotNull ITestResult result) {
        System.out.println("Test Failed");
        takeScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished");
    }

}
