package com.redbus.testing.utilities;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllUtilityFunction {

	// Properties object for config file
	Properties properties;

	// Default constructor
	public AllUtilityFunction() {
	}

	// WINDOW MANAGEMENT

	// Maximize browser window
	public void setMaximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// Minimize browser window
	public void setMinimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	// Fullscreen browser window
	public void setFullscreenBrowser(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	// Get browser window size
	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}

	// Set browser window size
	public void setSize(WebDriver driver, int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	// Get browser position
	public Point getPosition(WebDriver driver) {
		return driver.manage().window().getPosition();
	}

	// Set browser position
	public void setPosition(WebDriver driver, int x, int y) {
		driver.manage().window().setPosition(new Point(x, y));
	}

	// NAVIGATION

	// Navigate to application URL
	public void navigateToApplication(WebDriver driver,String url) {
		driver.navigate().to(url);
	}

	// Navigate forward
	public void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}

	// Navigate backward
	public void navigateBackward(WebDriver driver) {
		driver.navigate().back();
	}

	// Refresh current page
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	// Open URL using get()
	public void enterUrl(WebDriver driver,String url) {
		driver.get(url);
	}

	// DETAILS

	// Get page title
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// Get current URL
	public String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	// TIMEOUTS

	// Apply implicit wait
	public void implicitlyWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// Apply page load timeout
	public void pageLoadTimeout(WebDriver driver, int seconds) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}

	// EXPLICIT WAIT

	// Wait for element visibility
	public void waitForElementVisible(WebDriver driver, WebElement element, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for element clickable
	public void waitForElementClickable(WebDriver driver, WebElement element, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait until title contains text
	public void waitForTitleContains(WebDriver driver, String title, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.titleContains(title));
	}
	
	// ADVANCED EXPLICIT WAITS

	// Wait for visibility using locator
	public WebElement waitForVisibility(WebDriver driver, By locator, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Wait for presence using locator
	public WebElement waitForPresence(WebDriver driver, By locator, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait for all elements presence
	public List<WebElement> waitForAllElementsPresence(WebDriver driver, By locator, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	// Wait for clickable locator
	public WebElement waitForClickable(WebDriver driver, By locator, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait for clickable element
	public WebElement waitForClickable(WebDriver driver, WebElement element, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for refreshed clickable element
	public WebElement waitForRefreshedClickable(WebDriver driver, By locator, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.refreshed(
	                    ExpectedConditions.elementToBeClickable(locator)
	            ));
	}

	// Wait for refreshed visible element
	public WebElement waitForRefreshedVisibility(WebDriver driver, By locator, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.refreshed(
	                    ExpectedConditions.visibilityOfElementLocated(locator)
	            ));
	}

	// Wait until elements count is more than expected
	public List<WebElement> waitForElementsMoreThan(WebDriver driver, By locator, int count, int seconds) {
	    new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, count));
	    return driver.findElements(locator);
	}

	// Wait for invisibility of element
	public boolean waitForInvisibility(WebDriver driver, By locator, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// Wait for refreshed presence
	public WebElement waitForRefreshedPresence(WebDriver driver, By locator, int seconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.refreshed(
	                    ExpectedConditions.presenceOfElementLocated(locator)
	            ));
	}
	
	// Wait until elements count more than expected with default time
	public List<WebElement> waitForElementsMoreThan(WebDriver driver, By locator, int count) {
	    return new WebDriverWait(driver, Duration.ofSeconds(25))
	            .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, count));
	}

	// ALERT / POPUPS

	// Accept alert popup
	public void acceptPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// Dismiss alert popup
	public void dismissPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// Get popup text
	public String getPopupText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	// Print popup text
	public void printTextOnPopup(WebDriver driver) {
		System.out.println(driver.switchTo().alert().getText());
	}

	// Send text to popup
	public void sendTextToPopup(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// WINDOW HANDLES

	// Switch window by title
	public void switchToWindowByTitle(WebDriver driver, String textTitle) {
		Set<String> all = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		all.remove(currentWindowHandle);

		for (String window : all) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(textTitle)) {
				break;
			}
		}
	}

	// Switch window by URL
	public void switchToWindowByUrl(WebDriver driver, String url) {
		Set<String> all = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		all.remove(currentWindowHandle);

		for (String window : all) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

	// Close current browser
	public void closeBrowser(WebDriver driver) {
		driver.close();
	}

	// Quit browser session
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	// PROPERTIES UTILITIES

	// Load properties file
	public void initPropertiesUtility(String path) {

		try (FileInputStream fis = new FileInputStream(path);) {
			properties = new Properties();
			properties.load(fis);
			System.out.println("Properties : " + properties);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Get property value by key
	public String getPropertyData(String key) {
		if (properties != null) {
			return properties.getProperty(key);
		} else {
			System.err.println("Invalid Operation try again with proper property file");
			return null;
		}
	}

	// JAVA UTILITIES

	// Generate random number
	public int getRandomNumber(int range) {
		return new Random().nextInt(range);
	}

	// Get current date in required format
	public String getCurrentDate(String dateFormat) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.format(new Date());
	}

	// EXCEL UTILITY 
	
	// Excel file path
	private static final String FILE_PATH = "./src/test/resources/Readers/Config.xlsx";

	Workbook workbook;
	Sheet sheet;

	// Initialize workbook and sheet
	public void init(String sheetName) {

		try {
			FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
			workbook = WorkbookFactory.create(fileInputStream);
			sheet = workbook.getSheet(sheetName);
			fileInputStream.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Get row by row number
	public Row getRow(int rowNumber) {
		if (sheet == null) {
			System.out.println("Invaid Sheet : Initilize");
			return null;
		}
		return sheet.getRow(rowNumber);
	}

	// Get total rows count
	public int getNumberOfRows() {
		if (sheet == null) {
			System.out.println("Invaid Sheet : Initilize");
			return -1;
		}
		return sheet.getPhysicalNumberOfRows();
	}

	// Get total columns count
	public int getNumberOfCols() {
		if (sheet == null) {
			System.out.println("Invaid Sheet : Initilize");
			return -1;
		}
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	// Get cell data
	public String getData(int row, int col) {

		if (sheet == null) {
			System.out.println("Invaid Sheet : Initilize");
			return null;
		}
		CellType type = sheet.getRow(row).getCell(col).getCellType();

		if (type == CellType.NUMERIC) {
			String value = sheet.getRow(row).getCell(col).toString();
			return value.split("\\.")[0];
		}
		return sheet.getRow(row).getCell(col).toString();
	}

	// Get excel data as object array
	public Object[][] getExcelDataAsArray(String sheetName) throws Exception {

		try (FileInputStream fis = new FileInputStream(FILE_PATH); Workbook wb = WorkbookFactory.create(fis)) {

			Sheet sheet = wb.getSheet(sheetName);

			if (sheet == null) {
				throw new Exception("Sheet not found: " + sheetName);
			}
			int row = sheet.getLastRowNum();
			int col = sheet.getRow(0).getLastCellNum();
			Object[][] data = new Object[row][col];
			DataFormatter formatter = new DataFormatter();

			for (int i = 1; i <= row; i++) {
				Row currentRow = sheet.getRow(i);
				if (currentRow == null)
					continue;

				for (int j = 0; j < col; j++) {
					Cell cell = currentRow.getCell(j);

					if (cell == null) {
						data[i - 1][j] = "";
						continue;
					}

					switch (cell.getCellType()) {
					case NUMERIC:
						data[i - 1][j] = formatter.formatCellValue(cell);
						break;
					case BOOLEAN:
						data[i - 1][j] = cell.getBooleanCellValue();
						break;
					case STRING:
						data[i - 1][j] = cell.getStringCellValue();
						break;
					default:
						data[i - 1][j] = formatter.formatCellValue(cell);
						break;
					}
				}
			}

			return data;
		}
	}
}