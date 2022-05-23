package org.iti.utils;

import org.iti.actions.BrowserActions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestListener extends BrowserActions implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        PrintStream consoleFile;
        try {
            consoleFile = new PrintStream("./logs/TestListenerLog.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.setOut(consoleFile);

        System.out.println(iTestResult.getName() + " -> Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " -> Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " -> Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " -> Test Skipped");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("===================================================");
        System.out.println("||Test Finished on : " + iTestContext.getEndDate()+"||");
        System.out.println("===================================================");

    }
}
