package com.redbus.testing.utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

        	ExtentSparkReporter reporter =
        		    new ExtentSparkReporter("./Reports/ExtentReport.html");

            reporter.config().setReportName("RedBus Testing");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }
}