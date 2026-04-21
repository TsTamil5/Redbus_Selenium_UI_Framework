package com.redbus.testing.utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentCucumberAdapter implements ConcurrentEventListener {

    private static ExtentReports extent = ExtentManager.getReportInstance();

    private static ThreadLocal<ExtentTest> scenarioNode = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> stepNode = new ThreadLocal<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestCaseStarted.class, this::onScenarioStart);
        publisher.registerHandlerFor(TestStepStarted.class, this::onStepStart);
        publisher.registerHandlerFor(TestStepFinished.class, this::onStepFinish);
        publisher.registerHandlerFor(TestCaseFinished.class, this::onScenarioFinish);
    }

    private void onScenarioStart(TestCaseStarted event) {
        String scenarioName = event.getTestCase().getName();
        scenarioNode.set(extent.createTest(scenarioName));
    }

    private void onStepStart(TestStepStarted event) {

        if (event.getTestStep() instanceof PickleStepTestStep) {

            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();

            String stepText =
                    step.getStep().getKeyword() + step.getStep().getText();

            stepNode.set(scenarioNode.get().createNode(stepText));
        }
    }

    private void onStepFinish(TestStepFinished event) {

        if (event.getTestStep() instanceof PickleStepTestStep) {

            io.cucumber.plugin.event.Status status = event.getResult().getStatus();

            if (status == io.cucumber.plugin.event.Status.PASSED) {

                stepNode.get().pass("Step Passed");
            }
            else if (status == io.cucumber.plugin.event.Status.FAILED) {

                Throwable error = event.getResult().getError();

             // Save screenshot in folder
                ScreenshotUtility.captureScreenshot(
                        Base.getDriver(),
                        "StepFailure"
                );

                // Capture Base64 for report
                String base64 = captureScreenshotBase64();

                // Attach to report
                stepNode.get().fail(
                        error,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build()
                );
            }
            else {
                stepNode.get().skip("Step Skipped");
            }
        }
    }

    private void onScenarioFinish(TestCaseFinished event) {
        extent.flush();
    }

    // ✅ BASE64 screenshot (for report)
    private String captureScreenshotBase64() {

        try {
            return ((TakesScreenshot) Base.getDriver())
                    .getScreenshotAs(OutputType.BASE64);

        } catch (Exception e) {
            return null;
        }
    }
}