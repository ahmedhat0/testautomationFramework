package org.iti.analyzer;

import org.jetbrains.annotations.NotNull;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyTransformer implements IAnnotationTransformer, IRetryAnalyzer {
    int count = 0;
    int maxTry = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxTry) {
            count++;
            return true;
        }
        return false;
    }

    @Override
    public void transform(@NotNull ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {

        annotation.setRetryAnalyzer(MyTransformer.class);
    }
}
