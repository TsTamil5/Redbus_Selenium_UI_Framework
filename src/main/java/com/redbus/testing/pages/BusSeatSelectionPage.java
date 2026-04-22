package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RedBus.testing.utilities.Base;

public class BusSeatSelectionPage {

    WebDriver driver;
    WebDriverWait wait;

    public BusSeatSelectionPage(WebDriver driver) {
        this.driver =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    
    
    @FindBy(xpath = "//span[contains(@aria-label,'Seat number') and contains(@aria-label,'available')]")
    private List<WebElement> seats;
    
    public void selectGeneralSeat() {
        for (WebElement seat : seats) {

            String label = seat.getAttribute("aria-label").toLowerCase();

            if (label.contains("available") && !label.contains("female") && !label.contains("male")) {
                seat.click();
                break;
            }
        }
    }
    
 
    @FindBy(xpath = "//h3[@id='lower-deck-heading']/following::span[contains(@aria-label,'available')][2]")
    private WebElement lowerDeckSeat;

    @FindBy(xpath = "//h3[@id='upper-deck-heading']/following::span[contains(@aria-label,'available')][3]")
    private WebElement upperDeckSeat;

    @FindBy(xpath = "//button[contains(text(),'Select boarding & dropping points')]")
    private WebElement proceedButton;

    @FindBy(xpath = "//div[text()='Boarding points']")
    private WebElement boardingText;

    public void clickLowerDeckSeat() {
        wait.until(ExpectedConditions.elementToBeClickable(lowerDeckSeat)).click();
    }

    public void clickUpperDeckSeat() {
        wait.until(ExpectedConditions.elementToBeClickable(upperDeckSeat)).click();
    }

    public void selectAnyAvailableSeat() {
        try {
            clickLowerDeckSeat();
        } catch (Exception e) {
            clickUpperDeckSeat();
        }
    }

    public void clickProceedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
    }

    public String verifyBoardingPoint() {
        wait.until(ExpectedConditions.visibilityOf(boardingText));
        return boardingText.getText();
    }
}