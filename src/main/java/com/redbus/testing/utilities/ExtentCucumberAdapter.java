package com.redbus.testing.utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentCucumberAdapter implements ConcurrentEventListener {

    // Create single ExtentReports instance
    private static ExtentReports extent = ExtentManager.getReportInstance();

    // Store scenario node for each thread
    private static ThreadLocal<ExtentTest> scenarioNode = new ThreadLocal<>();

    // Store step node for each thread
    private static ThreadLocal<ExtentTest> stepNode = new ThreadLocal<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        // Register scenario start event
        publisher.registerHandlerFor(TestCaseStarted.class, this::onScenarioStart);

        // Register step start event
        publisher.registerHandlerFor(TestStepStarted.class, this::onStepStart);

        // Register step finish event
        publisher.registerHandlerFor(TestStepFinished.class, this::onStepFinish);

        // Register scenario finish event
        publisher.registerHandlerFor(TestCaseFinished.class, this::onScenarioFinish);
    }

    // Create test node when scenario starts
    private void onScenarioStart(TestCaseStarted event) {
        String scenarioName = event.getTestCase().getName();
        scenarioNode.set(extent.createTest(scenarioName));
    }

    // Create step node when each step starts
    private void onStepStart(TestStepStarted event) {

        if (event.getTestStep() instanceof PickleStepTestStep) {

            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();

            String stepText =
                    step.getStep().getKeyword() + step.getStep().getText();

            stepNode.set(scenarioNode.get().createNode(stepText));
        }
    }

    // Update report based on step result
    private void onStepFinish(TestStepFinished event) {

        if (event.getTestStep() instanceof PickleStepTestStep) {

            io.cucumber.plugin.event.Status status = event.getResult().getStatus();

            // Mark step as passed
            if (status == io.cucumber.plugin.event.Status.PASSED) {

                stepNode.get().pass("Step Passed");
            }

            // Mark step as failed with screenshot
            else if (status == io.cucumber.plugin.event.Status.FAILED) {

                Throwable error = event.getResult().getError();

                // Save screenshot in folder
                ScreenshotUtility.captureScreenshot(
                        Base.getDriver(),
                        "StepFailure"
                );

                // Capture Base64 screenshot for report
                String base64 = captureScreenshotBase64();

                // Attach screenshot to extent report
                stepNode.get().fail(
                        error,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build()
                );
            }

            // Mark step as skipped
            else {
                stepNode.get().skip("Step Skipped");
            }
        }
    }

    // Flush report after scenario completion
    private void onScenarioFinish(TestCaseFinished event) {
        extent.flush();
    }

    // Capture screenshot as Base64 string
    private String captureScreenshotBase64() {

        try {
            return ((TakesScreenshot) Base.getDriver())
                    .getScreenshotAs(OutputType.BASE64);

        } catch (Exception e) {
            return null;
        }
    }
}