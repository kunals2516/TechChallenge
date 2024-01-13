package org.interview.abstractcomponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    @Override
    public boolean retry(ITestResult iTestResult) {

        int count = 0;
        int maxTry = 1;

        if (count < maxTry) {
            count++;
            return true;
        }


        return false;
    }
}
