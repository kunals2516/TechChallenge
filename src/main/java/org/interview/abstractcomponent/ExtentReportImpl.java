package org.interview.abstractcomponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportImpl {

    static ExtentReports extent;
    static ExtentSparkReporter reporter;

    public static ExtentReports extentReportConfig() {
        extent = new ExtentReports();
//        String path = System.getProperty("user.dir") +"/src/test/java/org/interview/report/index.html";
        String path = System.getProperty("user.dir") +"/target/report/index.html";
//        reporter = new ExtentSparkReporter(new File(path));
        reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "QA");
        return extent;
    }
}
