package org.interview.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.interview.abstractcomponent.AbstractComponent;
import org.interview.abstractcomponent.ExtentReportImpl;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static org.interview.abstractcomponent.AbstractComponent.captureScreenShot;
import static org.openqa.selenium.devtools.v113.page.Page.captureScreenshot;


public class CustomListenersImpl implements ITestListener {

    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    ExtentReports extent = ExtentReportImpl.extentReportConfig();
    ExtentTest test;

    WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
//        ITestListener.super.onTestStart(result);
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        System.out.println("Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        extentTest.get().log(Status.PASS, "Test Passed");
        System.out.println("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        String filePath = null;
        try {
            filePath = captureScreenShot(result.getMethod().getMethodName(), driver);
            System.out.println("FilePath: " + filePath);
//          extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
            extentTest.get().addScreenCaptureFromPath("src/test/java/org/interview/screenshots" + result.getMethod().getMethodName() + ".png", null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        extentTest.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
        extent.flush();
    }
}
